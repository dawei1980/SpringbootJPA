package com.springboot.data.controller;

import com.springboot.data.entity.Content;
import com.springboot.data.entity.Surface;
import com.springboot.data.reponsitory.ContentRepository;
import com.springboot.data.reponsitory.EffectRepository;
import com.springboot.data.reponsitory.SurfaceRepository;
import com.springboot.data.util.DateUtil;
import com.springboot.data.util.JsonObjectResult;
import com.springboot.data.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/smartAdv")
public class SurfaceController {

    @Autowired
    private SurfaceRepository surfaceRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private EffectRepository effectRepository;

    @GetMapping(value = "/getSurface")
    public Object getSurface(@RequestParam(value = "surface_id") String surfaceId){
        if(!"".equals(surfaceId)){
            Surface surfaceInfo = surfaceRepository.findBySurfaceId(surfaceId);
            return new JsonObjectResult(ResultCode.SUCCESS, "获取数据成功",surfaceInfo);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }

    @GetMapping(value = "/getSurfaceAll")
    public Object getSurfaceAll(){
        List<Surface> mList = surfaceRepository.findAll();

        if(mList.size() != 0){
            return new JsonObjectResult(ResultCode.SUCCESS, "获取数据成功",mList);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }



}
