package com.demo.demo.service;

import com.demo.demo.model.File;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInterface {
        ResponseEntity<?> uploadFile(MultipartFile file);
        ResponseEntity<?>  downloadFile(String fileName);
        String saveFile(MultipartFile file);
        byte[] afficherfile(String filename);
}
