package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileService {
    String upLoad(MultipartFile file);

    List<String> getFiles();
}
