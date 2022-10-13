package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("upload")
public interface UploadService extends JpaRepository<Image, String> {
}
