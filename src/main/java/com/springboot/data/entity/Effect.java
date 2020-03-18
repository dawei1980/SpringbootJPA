package com.springboot.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "cm_effect")
public class Effect implements Serializable {
    @Id
    @NotEmpty(message = "Effect id cannot empty")
    @Column(name = "effect_id",nullable = false)
    private String effectId;

    @Column(name = "file_in")
    private int fileIn;

    @Column(name = "file_out")
    private int fileOut;

    @Column(name = "pic_always")
    private int picAlways;

    public String getEffectId() {
        return effectId;
    }

    public void setEffectId(String effectId) {
        this.effectId = effectId;
    }

    public int getFileIn() {
        return fileIn;
    }

    public void setFileIn(int fileIn) {
        this.fileIn = fileIn;
    }

    public int getFileOut() {
        return fileOut;
    }

    public void setFileOut(int fileOut) {
        this.fileOut = fileOut;
    }

    public int getPicAlways() {
        return picAlways;
    }

    public void setPicAlways(int picAlways) {
        this.picAlways = picAlways;
    }
}

