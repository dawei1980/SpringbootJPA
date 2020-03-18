package com.springboot.data.constant;

/**
 * @author Jiang dawei
 * @package com.trechina.smartadv.beans
 * @description: 常量
 * @date 2020/3/5 14:26
 */
public class Constants {

    public static final String UPLOAD_PATH = "D:/uploads/";

    /** Video storage path*/
    public static final String VIDEO_FILE_NAME = "video";
    public static final String VIDEO_FILE_PATH = UPLOAD_PATH + VIDEO_FILE_NAME;

    /**Image storage path*/
    public static final String IMG_FILE_NAME = "image";
    public static final String IMAGE_FILE_PATH = UPLOAD_PATH + IMG_FILE_NAME;

    /** Image relative path */
    public static final String VIRTUAL_VIDEO_PATH = "http://localhost:8091/video/";

    public static final String VIRTUAL_IMG_PATH = "http://localhost:8091/image/";
}
