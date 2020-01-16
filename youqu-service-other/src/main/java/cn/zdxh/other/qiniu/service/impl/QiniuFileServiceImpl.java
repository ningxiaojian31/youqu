package cn.zdxh.other.qiniu.service.impl;

import cn.zdxh.other.qiniu.entity.Qiniu;
import cn.zdxh.other.qiniu.service.QiniuFileService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QiniuFileServiceImpl implements QiniuFileService {

    @Autowired
    private Configuration configuration;

    @Autowired
    private Qiniu qiniu;

    @Autowired
    private Auth auth;

    @Override
    public boolean upload(byte[] uploadBytes,String newFilePath) {
        UploadManager uploadManager = new UploadManager(configuration);
        String token = auth.uploadToken(qiniu.getBucket());
        try {
            Response res = uploadManager.put(uploadBytes, newFilePath, token);
            System.out.println(res);
            if (res.isOK()){
                return true;
            }
        }catch (QiniuException e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public String download(String url) {
        //构建下载链接
        String downloadUrl = auth.privateDownloadUrl(url,3600);
        return downloadUrl;
    }
}
