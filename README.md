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
