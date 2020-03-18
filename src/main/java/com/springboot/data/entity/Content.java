package com.springboot.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "cm_content")
public class Content implements Serializable {
    @Id
    @Column(name = "content_id",nullable = false)
    private String contentId;

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

    @Column(name = "upload_time")
    private Timestamp uploadTime;

    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "effect_id",nullable = false)
    private Effect effect;

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
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

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaMd5() {
        return mediaMd5;
    }

    public void setMediaMd5(String mediaMd5) {
        this.mediaMd5 = mediaMd5;
    }
}

