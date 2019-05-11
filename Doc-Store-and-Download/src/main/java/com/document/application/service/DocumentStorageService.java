package com.document.application.service;

import com.document.application.exception.DocumentStorageException;
import com.document.application.exception.MyDocumentNotFoundException;
import com.document.application.model.DocumentStorageDTO;
import com.document.application.repository.DocumentStorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
/**
 * Author : Sunil Ngl 
 * */
@Service
public class DocumentStorageService {

    @Autowired
    private DocumentStorageRepository dbFileRepository;

    public DocumentStorageDTO storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DocumentStorageDTO dbFile = new DocumentStorageDTO(fileName, file.getContentType(), file.getBytes(),null);

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new DocumentStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    public DocumentStorageDTO storeAuthorFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DocumentStorageDTO dbFile = new DocumentStorageDTO(fileName, file.getContentType(),null, file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new DocumentStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DocumentStorageDTO getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyDocumentNotFoundException("File not found with id " + fileId));
    }
}
