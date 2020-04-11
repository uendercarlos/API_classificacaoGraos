
package com.example.demo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
 
  @author Uender Carlos
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;

    }

public void setUploadDir (String UploadDir){
    this.uploadDir=UploadDir;
    
}
}