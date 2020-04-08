package com.springboot.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cm_media")
public class MediaInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private String id;

    @Column(name = "media_id",nullable = false)
    private String mediaId;

    @Column(name = "media_url")
    private String mediaUrl;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "pic_md5")
    private String picMd5;

    @Column(name = "media_md5")
    private String mediaMd5;

    @Column(name = "file_type")
    private int fileType;

    @Column(name = "media_name")
    private String mediaName;

    @Column(name = "pic_name")
    private String picName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicMd5() {
        return picMd5;
    }

    public void setPicMd5(String picMd5) {
        this.picMd5 = picMd5;
    }

    public String getMediaMd5() {
        return mediaMd5;
    }

    public void setMediaMd5(String mediaMd5) {
        this.mediaMd5 = mediaMd5;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
