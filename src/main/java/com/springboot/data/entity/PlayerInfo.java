package com.springboot.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cm_player")
public class PlayerInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "player_id",nullable = false)
    private String playerId;

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

    @Column(name = "media_id",nullable = false)
    private String mediaId;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="media_id",referencedColumnName = "media_id")
    private Set<MediaInfo> mediaInfos = new HashSet<>();

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getIsLoop() {
        return isLoop;
    }

    public void setIsLoop(int isLoop) {
        this.isLoop = isLoop;
    }

    public Set<MediaInfo> getMediaInfos() {
        return mediaInfos;
    }

    public void setMediaInfos(Set<MediaInfo> mediaInfos) {
        this.mediaInfos = mediaInfos;
    }
}
