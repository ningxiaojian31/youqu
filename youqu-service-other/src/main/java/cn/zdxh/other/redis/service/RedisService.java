package cn.zdxh.other.redis.service;

public interface RedisService {

    /**
     * 设置缓存
     * @param key
     * @param val
     */
    default void put(String key, String val) {

    }

    /**
     *
     * @param key
     * @param val
     * @param minute 超时时间
     */
    default void put(String key, String val, int minute) {

    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    default Object get(String key) {
        return null;
    }

    /**
     * 删除缓存
     * @param key
     */
    default void remove(String key) {

    }

    /**
     * 存储set集合
     * @param key
     * @param val
     */
    void putSet(String key,Object val);

    /**
     * 返回set总数
     * @param key
     * @return
     */
    Long putSetCount(String key);

    Boolean putSetOr(String key, Object val);

    void moveSet(String key, Object val);
}