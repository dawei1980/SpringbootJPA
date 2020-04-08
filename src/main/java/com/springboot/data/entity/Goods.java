package com.springboot.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "goods_id", nullable = false)
    private long goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "price")
    private String price;

    @Column(name = "goods_describe")
    private String describe;

    @Column(name = "brand")
    private String brand;

    @Column(name = "goods_code")
    private String goodsCode;

    @Column(name = "produce_place")
    private String productPlace;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "average_score")
    private String averageScore;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "publish_time")
    private String publishTime;

    @Column(name = "sub_type_code")
    private String subTypeCode;

    @Column(name = "main_type")
    private String mainType;

    @Column(name = "main_type_code")
    private String mainTypeCode;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "goods_pic")
    private String goodsPic;

    @Column(name = "motorcycle_frame_number")
    private String motorcycleFrameNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "goods_image")
    private String goodsImage;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="goods_code",referencedColumnName = "goods_code")
    private Set<GoodsImage> goodsImagesSet = new HashSet<>();

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotorcycleFrameNumber() {
        return motorcycleFrameNumber;
    }

    public void setMotorcycleFrameNumber(String motorcycleFrameNumber) {
        this.motorcycleFrameNumber = motorcycleFrameNumber;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSubTypeCode() {
        return subTypeCode;
    }

    public void setSubTypeCode(String subTypeCode) {
        this.subTypeCode = subTypeCode;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getMainTypeCode() {
        return mainTypeCode;
    }

    public void setMainTypeCode(String mainTypeCode) {
        this.mainTypeCode = mainTypeCode;
    }

    public Set<GoodsImage> getGoodsImagesSet() {
        return goodsImagesSet;
    }

    public void setGoodsImagesSet(Set<GoodsImage> goodsImagesSet) {
        this.goodsImagesSet = goodsImagesSet;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }
}
