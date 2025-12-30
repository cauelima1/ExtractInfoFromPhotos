package info.photos;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@SpringBootApplication
public class PhotosInfoApplication {

		public static void main(String[] args) {

			boolean continua = true;
			while(continua) {
				System.out.println("Digite o caminho da pasta:");
				Scanner scan = new Scanner(System.in);
				String caminhoPasta = scan.nextLine();
				System.out.println(caminhoPasta);
				String usuario = System.getProperty("user.name");
				String arquivoSaida = "C:\\Users\\" + usuario + "\\Downloads\\MetaDados.csv";

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
					// Cabeçalho da planilha
					writer.write("Arquivo;DataHora;Latitude;Longitude;Altitude\n");

					Files.list(Paths.get(caminhoPasta))
							.filter(Files::isRegularFile)
							.filter(path -> path.toString().toLowerCase().endsWith(".jpg"))
							.forEach(path -> {
								try {
									Metadata metadata = ImageMetadataReader.readMetadata(path.toFile());

									// Data e hora
									ExifSubIFDDirectory exif = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
									String dataHora = exif != null ? exif.getDateOriginal() + "" : "";

									// Coordenadas GPS
									GpsDirectory gps = metadata.getFirstDirectoryOfType(GpsDirectory.class);
									String latitude = "";
									String longitude = "";
									String altitude = "";

									if (gps != null && gps.getGeoLocation() != null) {
										latitude = String.format("%.6f", gps.getGeoLocation().getLatitude());
										longitude = String.format("%.6f", gps.getGeoLocation().getLongitude());
										if (gps.getRational(GpsDirectory.TAG_ALTITUDE) != null) {
											altitude = gps.getRational(GpsDirectory.TAG_ALTITUDE).doubleValue() + " m";
										}
									}

									// Escreve linha no CSV
									writer.write(path.getFileName() + ";" + dataHora + ";" +
											latitude + ";" + longitude + ";" + altitude + "\n");

								} catch (Exception e) {
									System.err.println("Erro ao ler " + path + ": " + e.getMessage());
								}
							});
					System.out.flush();
					System.out.println("Planilha gerada em: " + arquivoSaida);


				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Deseja informar outro caminho ?(S/N)");
				String escolha = scan.next();

				if (escolha.toLowerCase().equals("n")) {
					continua = false;
				}
				caminhoPasta = "";
			}
		}
}




