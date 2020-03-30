package com.springboot.data.controller;

import com.springboot.data.entity.Goods;
import com.springboot.data.entity.GoodsImage;
import com.springboot.data.image.upload.UploadFileUtil;
import com.springboot.data.reponsitory.GoodsReponsitory;
import com.springboot.data.util.JsonObjectResult;
import com.springboot.data.util.RandomCodeUtil;
import com.springboot.data.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/goods/api")
public class GoodsController {

    @Autowired
    public GoodsReponsitory goodsRepository;

    /**
     * 添加商品信息
     * upload_type = 3
     * @return 是否发布成功
     */
    @PostMapping(value = "/addGoods")
    public Object add(@RequestParam(name = "username") String username,
                      @RequestParam(name = "goodName") String goodName,
                      @RequestParam(name = "goodPrice") String goodPrice,
                      @RequestParam(name = "quantity") String quantity,
                      @RequestParam(name = "productPlace") String productPlace,
                      @RequestParam(name = "motorcycleFrameNumber") String motorcycleFrameNumber,
                      @RequestParam(name = "subType") String subType,
                      @RequestParam(name = "brand") String brand,
                      @RequestParam("upload_goods_image") MultipartFile[] files) {

        if (!StringUtils.isEmpty(username) &&
                !StringUtils.isEmpty(goodName) &&
                !StringUtils.isEmpty(goodPrice) &&
                !StringUtils.isEmpty(quantity) &&
                !StringUtils.isEmpty(productPlace) &&
                !StringUtils.isEmpty(motorcycleFrameNumber) &&
                !StringUtils.isEmpty(subType) &&
                !StringUtils.isEmpty(brand)) {

            Goods goods = new Goods();
            String goodsCode = RandomCodeUtil.getUUIDByRules(username);

            goods.setGoodsCode(RandomCodeUtil.createData(16));
            goods.setBrand(brand);
            goods.setGoodsName(goodName);
            goods.setPrice(goodPrice);
            goods.setMotorcycleFrameNumber(motorcycleFrameNumber);
            goods.setProductPlace(productPlace);
            goods.setQuantity(quantity);
            goods.setSubType(subType);
            goods.setSellerName(username);
            goods.setGoodsCode(goodsCode);

            List<GoodsImage> goodsImageList = new ArrayList<>();

            try {
                //保存图片
                for(int i=0; i<files.length; i++){
                    GoodsImage goodsImage = new GoodsImage();

                    /**一对多同时上传图片或数据*/
                    String path = UploadFileUtil.saveImg(files[i],username);
                    goodsImage.setImageUrl(path);

                    goods.getGoodsImagesSet().add(goodsImage);
                    goodsImageList.add(goodsImage); //存储goodsImage
                }
                goodsRepository.save(goods);
            }catch (Exception e){
                //打印错误堆栈信息
                e.printStackTrace();
            }
            /**获取第一张图片作为封面*/
            String firstImagePath = goodsImageList.get(0).getImageUrl();
            goods.setGoodsImage(firstImagePath);

            return new JsonObjectResult(ResultCode.SUCCESS, "上传数据成功",goods);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数丢失");
        }
    }

    /**删除数据*/
    @PostMapping(value = "/deleteGoodsInfo")
    public Object deleteGoodsInfo(@RequestParam(value = "goods_id") String id){

        long goodsId = Long.parseLong(id);

        if(goodsId != 0){
            int deleteGoodsInfo = goodsRepository.deleteGoods(goodsId);
            return new JsonObjectResult(ResultCode.SUCCESS, "删除数据成功",deleteGoodsInfo);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }

    /**修改数据*/
    @PostMapping(value = "/updateGoodsInfo")
    public Object updateGoodsInfo(@RequestParam(value = "goods_id") String id,
                                  @RequestParam(value = "goods_name") String goodsName,
                                  @RequestParam(value = "price") String price,
                                  @RequestParam(value = "quantity") String quantity){

        long goodsId = Long.parseLong(id);

        if(goodsId != 0){
            int updateGoodsInfo = goodsRepository.updateGoodsInfo(goodsId,goodsName,price,quantity);
            return new JsonObjectResult(ResultCode.SUCCESS, "删除数据成功",updateGoodsInfo);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }

    /**查询数据*/
    @PostMapping(value = "queryGoods")
    public Object queryGoods(@RequestParam(value = "goods_name") String goodsName){

        if(!"".equals(goodsName)){
            List<Goods> queryList = goodsRepository.findAllByGoodsNameLike("%"+goodsName+"%");
            return new JsonObjectResult(ResultCode.SUCCESS, "查询数据成功",queryList);
        }else {
            return new JsonObjectResult(ResultCode.PARAMS_ERROR, "参数错误");
        }
    }
}
