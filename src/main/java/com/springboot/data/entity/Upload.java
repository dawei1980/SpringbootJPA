package com.springboot.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cm_upload")
public class Upload implements Serializable {
    @Id
    @Column(name = "content_id",nullable = false)
    private String contentId;

    @Column(name = "media_name",nullable = false)
    private String mediaName;

    @Column(name = "image_name",nullable = false)
    private String imageName;

    @Column(name = "media_url",nullable = false)
    private String mediaUrl;

    @Column(name = "image_url",nullable = false)
    private String imageUrl;

    @Column(name = "file_type",nullable = false)
    private int fileType;

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
