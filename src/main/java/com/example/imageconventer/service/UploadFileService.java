package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String upLoad(MultipartFile file);
}
