package com.SoulCode.Services.Controllers;

import com.SoulCode.Services.Services.EmployeeService;
import com.SoulCode.Services.Util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;

// CrossOrigin serve para evitar erros de CORS ()
@CrossOrigin
@RestController
@RequestMapping("services")
public class UploadFileController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee/uploadPhoto/{idEmployee}")
    //RequestParam significa que o nome do arquivo será passado pelo parâmetro da requisição
    public ResponseEntity<Void> uploadPhoto(@PathVariable Integer idEmployee,
                                            MultipartFile multipartFile,
                                            @RequestParam("name") String name){
        String fileName = name;
        String uploadDir = "D:/LUCAS LOPES/TEMPORARIOS/fotosExApiJava";
        String namePlusPath = "D:/LUCAS LOPES/TEMPORARIOS/fotosExApiJava/" + name;



        try{
            UploadFile.saveFile(uploadDir, fileName ,multipartFile);
            employeeService.savePhoto(idEmployee,namePlusPath);
        } catch (IOException e){
            System.out.println("O aquivo não foi enviado"+ e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


}
