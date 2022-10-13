package com.example.imageconventer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service("upload.file")
public class UploadFileServiceImpl implements UploadFileService{
    private final String PATH = "C:\\Tung\\nam4\\pbl6\\repo\\python\\image\\";

    public String upLoad(MultipartFile file){
        Path filePath = Paths.get(PATH, file.getOriginalFilename());
        try(OutputStream os = Files.newOutputStream(filePath)){
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "OK";
    }
}
