package cn.zdxh.commons.pojo;

import lombok.Data;

@Data
public class UploadResult {
    public long fsize;
    public String key;
    public String hash;
    public int width;
    public int height;
}