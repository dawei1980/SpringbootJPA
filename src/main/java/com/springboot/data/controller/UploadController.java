package com.springboot.data.controller;

import com.springboot.data.entity.Upload;
import com.springboot.data.reponsitory.UploadReponsitory;
import com.springboot.data.util.JsonObjectResult;
import com.springboot.data.util.ResultCode;
import com.springboot.data.util.UploadFileWithMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/smartAdv")
public class UploadController {

    @Autowired
    private UploadReponsitory uploadReponsitory;

    @PostMapping(value = "/uploadFiles")
    public Object uploadFiles(@RequestParam("adv_video") MultipartFile video,
                              @RequestParam("adv_image") MultipartFile image,
                              @RequestParam("content_id") String contentId,
                              @RequestParam("video_name") String videoName,
                              @RequestParam("image_name") String imageName,
                              @RequestParam("file_type") int fileType){
        if(!"".equals(contentId) && !"".equals(videoName) && !"".equals(imageName)){
            Upload upload = new Upload();
            upload.setMediaUrl(UploadFileWithMD5Util.saveVideo(video,videoName));
            upload.setImageUrl(UploadFileWithMD5Util.saveImg(image,imageName));
            upload.setContentId(contentId);
            upload.setMediaName(videoName + "." + UploadFileWithMD5Util.getFileSuffix(video.getOriginalFilename()));
            upload.setImageName(imageName + "." + UploadFileWithMD5Util.getFileSuffix(image.getOriginalFilename()));
            upload.setFileType(fileType);
            uploadReponsitory.save(upload);
            return new JsonObjectResult(ResultCode.SUCCESS, "Insert data success",upload);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "The parameter is null");
        }
    }

}
