package com.springboot.data.image.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.data.image.constants.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * 配置的图片映射
     */
//    private static final String imgPath = "file:" + Constants.UPLOAD_PATH + Constants.IMG_FILE_NAME + Constants.USERNAME + "/";
//    private static final String authenticationPath = "file:" + Constants.UPLOAD_PATH + Constants.AUTHENTICATION_IMAGES + Constants.USERNAME + "/";

    private static final String goodsPath = "file:" + Constants.UPLOAD_PATH + Constants.GOODS_IMAGES + Constants.USERNAME + "/";

//    private static final String servicePath = "file:" + Constants.UPLOAD_PATH + Constants.SERVICE_IMAGES + Constants.USERNAME + "/";
//    private static final String leasePath = "file:" + Constants.UPLOAD_PATH + Constants.LEASE_IMAGES + Constants.USERNAME + "/";
//    private static final String ornamentPath = "file:" + Constants.UPLOAD_PATH + Constants.ORNAMENT_IMAGES + Constants.USERNAME + "/";
//    private static final String rescuePath = "file:" + Constants.UPLOAD_PATH + Constants.RESCUE_IMAGES + Constants.USERNAME + "/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //将所有访问img/virtual/**的请求映射到文件上传的路径下 C:\Users\wanghao/upload/img（图片的保存路径）
        registry.addResourceHandler("/goods/**").addResourceLocations(goodsPath);

//        registry.addResourceHandler("/images/**").addResourceLocations(imgPath);
//        registry.addResourceHandler("/authentication/**").addResourceLocations(authenticationPath);
//        registry.addResourceHandler("/service/**").addResourceLocations(servicePath);
//        registry.addResourceHandler("/lease/**").addResourceLocations(leasePath);
//        registry.addResourceHandler("/ornament/**").addResourceLocations(ornamentPath);
//        registry.addResourceHandler("/rescue/**").addResourceLocations(rescuePath);
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //升级最新版本需加=============================================================
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);

        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        //WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
        //WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
        //DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
        //WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
        //WriteMapNullValue：是否输出值为null的字段,默认为false
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(mediaTypeList);
        converters.add(fastConverter);
    }

}
