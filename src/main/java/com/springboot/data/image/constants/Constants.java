package com.springboot.data.image.constants;

public class Constants {
    /** 文件头像上传/图片   根目录 */
//    public static final String UPLOAD_PATH = System.getProperty("user.home") + "/upload/";

    /**IP和端口号*/
    public static final String URL = "http://172.18.5.86:7456/";

    /**文件存储地址*/
//    public static final String UPLOAD_PATH = "/opt/images";
    public static final String UPLOAD_PATH = "D:/UploadImages/";

    /**商品图片存储路径*/
    public static final String GOODS_IMAGES = "goods/";

    /**商品图片上传相对路径*/
    public static final String VIRTUAL_GOODS_PATH = URL + GOODS_IMAGES;

    /**根据username存储图片*/
    public static String USERNAME = "";
}
