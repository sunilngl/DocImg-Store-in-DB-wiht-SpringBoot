package com.document.application.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * Author : Sunil Ngl 
 * */
@Entity
@Table(name = "files")
public class DocumentStorageDTO {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    
    @Lob
    private byte[] AuthorCard;

    public DocumentStorageDTO() {

    }

    public DocumentStorageDTO(String fileName, String fileType, byte[] data,byte[] AuthorCard) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.AuthorCard = AuthorCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

	public byte[] getAuthorCard() {
		return AuthorCard;
	}

	public void setAuthorCard(byte[] authorCard) {
		AuthorCard = authorCard;
	}
    
}
