package com.springboot.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cm_surface")
public class Surface implements Serializable {
    @Id
    @NotEmpty(message = "Surface id cannot empty")
    @Column(name = "surface_id",nullable = false)
    private String surfaceId;

    @Column(name = "coordinate_x")
    private int coordinateX;

    @Column(name = "coordinate_y")
    private int coordinateY;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "is_audio",nullable = false)
    private int audio;

    @Column(name = "is_loop",nullable = false)
    private int isLoop;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="surface_id",referencedColumnName = "surface_id",nullable = false)
    private Set<Content> contentSet = new HashSet<>();

    public Set<Content> getContentSet() {
        return contentSet;
    }

    public void setContentSet(Set<Content> contentSet) {
        this.contentSet = contentSet;
    }

    public String getSurfaceId() {
        return surfaceId;
    }

    public void setSurfaceId(String surfaceId) {
        this.surfaceId = surfaceId;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIsLoop() {
        return isLoop;
    }

    public void setIsLoop(int isLoop) {
        this.isLoop = isLoop;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int isAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
