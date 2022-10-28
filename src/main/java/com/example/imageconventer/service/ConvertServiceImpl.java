package com.example.imageconventer.service;

import com.example.imageconventer.model.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService{

    @Autowired
    LoginUser loginUser;
    @Override
    public String Convert(String listFile) throws IOException {
        List<String> fileArr = Arrays.asList(listFile.split(","));
        for(String fileName : fileArr){
            String file = loginUser.getUsername() + "_" + fileName;
            URL url = new URL("http://127.0.0.1:5000/convert/vi?listFile=" + file);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                System.out.println(inputLine);
            }
            in.close();
            con.disconnect();
        }
        return "";
    }
}
