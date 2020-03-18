package com.springboot.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods_images")
public class GoodsImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "goods_images_id", nullable = false)
    private long id;

    @Column(name = "image_url")
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
