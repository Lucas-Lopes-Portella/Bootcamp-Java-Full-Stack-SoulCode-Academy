package com.SoulCode.Services.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadFile {


    public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws IOException {
        //MultipartFile --> É o arquivo completo
        //Path atribui ao objeto uploadPath o caminho (uploadDir) do arquivo
        Path uploadPath = Paths.get(uploadDir);

        // se o caminho (uploadDir) não existir, ele será criado dentro do if
        if(!Files.notExists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        // Tentar fazer o upload do arquivo
        // InputStream tenta fazer a leitura do arquivo que queremos subir e faz a leitura byte por byte do arquivo

        // Nesse momento o arquivo é salvo no diretório
        try (InputStream inputStream = file.getInputStream()) {

            // Classe Path --> permite fazer o upload do path e resolve a execução do upload
            Path filePath = uploadPath.resolve(fileName);

            //Momento da cópia do arquivo que está no HD para o local que será realizado o upload
            // REPLACE_EXISTING --> Se o arquivo já existe, ele vai substituir
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e){
            throw new IOException("Não foi possível enviar o seu arquivo");
        }
    }
}
