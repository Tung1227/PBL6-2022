package com.example.imageconventer.service;

import com.example.imageconventer.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("upload")
public interface UploadService extends JpaRepository<Image, String> {
    @Query("Select i from Image i where i.user.userName = ?1")
    List<Image> findByUserName(String username);

    @Query("select i from Image i where i.user.userName = ?1 and i.imageFile = ?2")
    Image findByUserNameAndFileName(String username, String filename);
}
