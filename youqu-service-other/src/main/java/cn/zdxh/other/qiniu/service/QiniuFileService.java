package cn.zdxh.other.qiniu.service;

/**
 * 七牛云服务层
 */
public interface QiniuFileService {
    //上传文件
    public boolean upload(byte[] uploadBytes,String newFilePath);
    //下载文件
    public String download(String url);
}
