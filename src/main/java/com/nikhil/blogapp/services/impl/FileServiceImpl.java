package com.nikhil.blogapp.services.impl;

import com.nikhil.blogapp.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // Filename
        String name = file.getOriginalFilename();

        // Random Name Generate
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));

        // Full path
        String filePath = path + File.separator + fileName1;

        // create folder if not created
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        // copy file
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
