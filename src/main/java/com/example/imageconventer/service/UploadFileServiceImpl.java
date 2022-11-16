package com.example.imageconventer.service;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.model.entity.Image;
import com.example.imageconventer.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service("upload.file")
public class UploadFileServiceImpl implements UploadFileService{
    @Autowired
    LoginService loginService;
    @Autowired
    LoginUser loginUser;
    @Autowired
    UploadService uploadService;
    private final String PATH = "C:\\Tung\\nam4\\pbl6\\python\\static\\image\\";

    public String upLoad(MultipartFile file){
        String fileName = file.getOriginalFilename();
        Image oldImg = uploadService.findByUserNameAndFileName(loginUser.getUsername(), fileName);
        Path filePath = Paths.get(PATH,loginUser.getUsername() + "_" +file.getOriginalFilename());
        try(OutputStream os = Files.newOutputStream(filePath)){
            os.write(file.getBytes());
        } catch (IOException e) {
            return "";
        }
        if(oldImg != null && oldImg.isDeleted()){
            oldImg.setDeleted(false);
            uploadService.save(oldImg);
            return fileName;
        }
        else if(oldImg != null && !oldImg.isDeleted()){
            return "";
        }
        Image img = new Image();
        img.setImageFile(fileName);
        User u = loginService.findUserByUserName(loginUser.getUsername());
        img.setUser(u);
        uploadService.save(img);
        return fileName;
    }

    public List<String> getFiles(){
        List<String> fileNames = new ArrayList<>();
        if(loginUser !=null){
            List<Image> imgs = uploadService.findByUserName(loginUser.getUsername());
            for(Image i : imgs){
                if(i.isDeleted() || i.isStatus()){
                    continue;
                }
                fileNames.add(i.getImageFile());
            }
        }
        return fileNames;
    }

    @Override
    public Boolean deleteFile(String fileName) {
        Image img = uploadService.findByUserNameAndFileName(loginUser.getUsername(), fileName);
        if(img != null){
            img.setDeleted(true);
            uploadService.save(img);
            return true;
        }else{
            return false;
        }
    }

}
