package com.example.imageconventer.service;

import com.example.imageconventer.model.dto.LoginUser;
import com.example.imageconventer.model.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService{

    private String POST_URL = "http://localhost:8081/api/convert";
//    private final String PATH = "\\home\\pbl6\\upload\\text\\";
    private final String PATH = "C:\\Tung\\nam4\\pbl6\\python\\static\\text\\";
    @Autowired
    LoginUser loginUser;
    @Autowired
    UploadService uploadService;

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
                Image i = uploadService.findByUserNameAndFileName(loginUser.getUsername(), fileName);
                i.setStatus(true);
                uploadService.save(i);
                successList.add(fileName);
            } else {
                System.out.println("POST request not worked");
            }
        }
        return successList;
    }

    @Override
    public ResponseEntity<Resource> DownloadFile(String s) {
        String fileTextName = "";
        HttpHeaders headers = new HttpHeaders();

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        StringBuilder content = new StringBuilder();
        String line = "";
        BufferedReader in = null;
        fileTextName = s.substring(0, s.lastIndexOf('.')) + ".txt";
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileTextName);
        File f = new File(PATH + loginUser.getUsername() + "_" + fileTextName);
        Path path = Paths.get(f.getAbsolutePath()) ;
        ByteArrayResource resource = null;
        try {
            resource = new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(f.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
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
