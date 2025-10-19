package com.demo.demo.service;

import com.demo.demo.DAO.FileRepository;
import com.demo.demo.model.File;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
@Service
public class FileServiceImplement implements  FileServiceInterface{
    private static final Logger LOGGER= LoggerFactory.getLogger(FileServiceImplement.class.getName());
    private final FileRepository fileRepository;

    public FileServiceImplement(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file) {
        try{
        if(! this.fileRepository.existsByFilename(file.getOriginalFilename())){
            File newfile = new File();
            newfile.setFilename(file.getOriginalFilename());
            newfile.setContentType(file.getContentType());
            newfile.setSize(file.getSize());
            newfile.setData(file.getBytes());
            return new ResponseEntity<>("File uploaded successfully"+ fileRepository.save(newfile), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("File already exists", HttpStatus.CONFLICT);
        }
        }
        catch (IOException e){
            LOGGER.error("error getting data from file",e.getMessage());
            return new ResponseEntity<>("Error when getting data from file", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> downloadFile(String fileName) {
        Optional<File> optionalFile= this.fileRepository.findByFilename(fileName);
        if(optionalFile.isPresent()){
            File file= optionalFile.get();
            return new ResponseEntity<>(file, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
Path imagePath1= Paths.get("uploads/pdf");
    Path imagePath2= Paths.get("uploads/image");
    @Override
    public String saveFile(MultipartFile file) {
        String originalFilename= file.getOriginalFilename();
        String extention= originalFilename.substring(originalFilename.lastIndexOf("."));
        String randomNamed= RandomStringUtils.randomAlphanumeric(10)+extention;
        File newfile = new File();
        newfile.setFilename(randomNamed);

       try{    if(extention.equals(".pdf")){
           Files.copy(file.getInputStream(),imagePath1.resolve(randomNamed));
         }
           else{
           Files.copy(file.getInputStream(),imagePath2.resolve(randomNamed));

       } fileRepository.save(newfile);

       }
       catch (IOException e){
           throw new RuntimeException(e);
       }
       return randomNamed;
    }

    @Override
    public byte[] afficherfile(String filename) {

        String extention= filename.substring(filename.lastIndexOf("."));

        try{
            Path filePath;
            if(extention.equals(".pdf")){
               filePath=imagePath1.resolve(filename);
            }
            else{
            filePath=imagePath2.resolve(filename);
        }
            return Files.readAllBytes(filePath);
        }catch (Exception e){
 throw new RuntimeException(e);
        }
    }
}
