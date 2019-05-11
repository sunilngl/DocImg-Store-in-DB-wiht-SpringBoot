package com.document.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.document.application.model.DocumentStorageDTO;
/**
 * Author : Sunil Ngl 
 * */
@Repository
public interface DocumentStorageRepository extends JpaRepository<DocumentStorageDTO, String> {

}
