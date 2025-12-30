# 📸 Photos Info Application

Aplicação em **Java + Spring Boot** para extração de metadados de imagens **.jpg** (EXIF e GPS) e geração de um arquivo **CSV** com informações organizadas.

---

## 🚀 Funcionalidades

- Solicita ao usuário o caminho de uma pasta contendo imagens `.jpg`.
- Lê os metadados de cada foto utilizando a biblioteca [metadata-extractor](https://github.com/drewnoakes/metadata-extractor).
- Extrai:
  - **Nome do arquivo**
  - **Data e hora original da foto**
  - **Latitude**
  - **Longitude**
  - **Altitude**
- Gera automaticamente um arquivo `MetaDados.csv` na pasta `Downloads` do usuário.
- Permite repetir o processo para diferentes pastas até que o usuário decida encerrar.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+** (ou versão compatível)
- **Spring Boot** (para estruturação do projeto)
- **metadata-extractor** (biblioteca para leitura de metadados EXIF/GPS)
- **NIO Files API** (para manipulação de arquivos e diretórios)

---

## 📂 Estrutura do CSV

O arquivo `MetaDados.csv` gerado possui o seguinte formato:


## ⚙️ Instalação

### Pré-requisitos
- **Java JDK 17+** instalado e configurado no `PATH`.
- **Maven** instalado (ou uso do wrapper `mvnw`).
- Sistema operacional Windows (o caminho de saída está configurado para `C:\Users\<usuario>\Downloads`).

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/photos-info-application.git
   cd photos-info-application

      ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Gere o arquivo `.jar`:
   ```bash
   mvn package
   ```

---

## ▶️ Como Rodar

1. Execute o `.jar` gerado:
   ```bash
   java -jar target/photos-info-application.jar
   ```

2. Digite o caminho da pasta com suas fotos `.jpg` quando solicitado:
   ```
   Digite o caminho da pasta:
   C:\Users\Cauê\Pictures\Viagem
   ```

3. O arquivo `MetaDados.csv` será criado em:
   ```
   C:\Users\<seu_usuario>\Downloads\MetaDados.csv
   ```

4. O programa perguntará se deseja processar outra pasta:
   ```
   Deseja informar outro caminho ?(S/N)
   ```

---

## ⚠️ Observações

- Apenas arquivos `.jpg` são processados.
- Fotos sem metadados EXIF/GPS terão campos em branco.
- O arquivo `MetaDados.csv` é sobrescrito a cada execução.
- É necessário ter permissões de leitura na pasta informada e de escrita na pasta `Downloads`.

---

## 📌 Exemplo de Uso

```
Digite o caminho da pasta:
C:\Users\Cauê\Pictures\Viagem

Planilha gerada em: C:\Users\Cauê\Downloads\MetaDados.csv
Deseja informar outro caminho ?(S/N)
```

---

## 👨‍💻 Autor

Desenvolvido para facilitar a organização e análise de metadados de fotos digitais.
```


