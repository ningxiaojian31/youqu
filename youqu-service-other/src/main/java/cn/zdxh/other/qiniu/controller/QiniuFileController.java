package cn.zdxh.other.qiniu.controller;

import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.other.email.service.IMailService;
import cn.zdxh.other.qiniu.entity.Qiniu;
import cn.zdxh.other.qiniu.service.QiniuFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;

@RestController
@Api(tags = "七牛云上传和下载")
@RequestMapping("/qiniu/file")
public class QiniuFileController {

    @Autowired
    private QiniuFileService qiniuFileService;

    @Autowired
    IMailService iMailService;

    @Autowired
    private Qiniu qiniu;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception{
        if (file == null){
            throw new WebRuntimeException("上传的文件不能为空");
        }
        Result result = new Result();
        String originalFilename = file.getOriginalFilename();
        //新文件名
        String newFilePath = UUID.randomUUID() +originalFilename.substring(originalFilename.lastIndexOf("."));
        //进行流转换
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try{
            is = file.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] uploadBytes = bos.toByteArray();
            //进行上传
            boolean uploadResult = qiniuFileService.upload(uploadBytes, newFilePath);
            if (!uploadResult){
                result.error("上传失败，请检查网络！");
                return result;
            }
            //图片访问路径
            String urlPath = qiniu.getUrl()+newFilePath;
            result.success(urlPath);
        }finally {
            //关闭流
            if (is != null){
                is.close();
            }
            if (bos != null){
                bos.close();
            }
        }

        return result;
    }

    @ApiOperation("文件下载")
    @GetMapping("/download")
    @ApiImplicitParam(value = "下载文件名",name = "fileName",required = true,dataType = "string")
    public Result upload(String fileName){
        Result result = new Result();
        //构建真实下载路径
        String url = qiniu.getUrl()+fileName;
        String downloadUrl = qiniuFileService.download(url);
        result.success(downloadUrl);
        return result;
    }

}
