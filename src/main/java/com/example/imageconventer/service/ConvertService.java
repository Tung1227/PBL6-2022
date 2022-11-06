package com.example.imageconventer.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ConvertService {
    public List<String> Convert(String fileNaeme) throws IOException;

    List<String> DownloadFile(String listFile);

    String readFile(String s);
}
