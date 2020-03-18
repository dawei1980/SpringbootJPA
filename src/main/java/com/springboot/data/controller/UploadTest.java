package com.springboot.data.controller;

import com.springboot.data.util.FileMD5Util;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

public class UploadTest {
    public static void main(String[] args){
        String path = "D:/uploads/video/cartoon.mp4";
        File file = new File(path);
        String md5Str = FileMD5Util.calcMD5(file);
        System.out.println(md5Str);
    }

    /**
     * 获取上传文件的md5
     *
     * @param file
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public String getMd5(MultipartFile file) {

        try {
            byte[] uploadBytes = file.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
