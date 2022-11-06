package com.example.imageconventer.service;

import com.example.imageconventer.model.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService{

    private String POST_URL = "http://localhost:8081/api/convert";

    private final String PATH = "C:\\Tung\\nam4\\pbl6\\python\\static\\text\\";
    @Autowired
    LoginUser loginUser;
    @Override
    public List<String> Convert(String listFile) throws IOException {
        List<String> fileArr = Arrays.asList(listFile.split(","));
        List<String> successList = new ArrayList<>();
         for(String fileName : fileArr){
            String file = loginUser.getUsername() + "_" + fileName;
            URL obj = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(("name="+file).getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();

            System.out.println("POST Response Code :: " + responseCode);


            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                successList.add(fileName);
            } else {
                System.out.println("POST request not worked");
            }
        }
        return successList;
    }

    @Override
    public List<String> DownloadFile(String listFile) {
        return null;
    }

    @Override
    public String readFile(String s) {
        String fileTextName = "";
        StringBuilder content = new StringBuilder();
        String line = "";
        BufferedReader in = null;
        fileTextName = s.substring(0, s.lastIndexOf('.')) + ".txt";
        try {
            in = new BufferedReader(new FileReader(PATH + loginUser.getUsername() + "_" + fileTextName));
            while((line = in.readLine()) != null){
                content.append(line);
                content.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(content.equals("")){
            content.append("File not found!!!");
        }
        return content.toString();
    }
}
