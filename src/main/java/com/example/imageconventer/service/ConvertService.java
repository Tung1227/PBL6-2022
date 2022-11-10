package com.example.imageconventer.service;

import org.springframework.core.io.Resource;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ConvertService {
    public List<String> Convert(String fileNaeme) throws IOException;

    ResponseEntity<Resource> DownloadFile(String listFile);

    String readFile(String s);
}
