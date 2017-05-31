package cn.dintama.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by dintama on 2017/5/31.
 */
@Component
public class RedisDataSource {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public boolean set(final String key, final String value){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                if(key == null){
                    return false;
                }

                byte[] redisKey = serializer.serialize(key);
                byte[] redisValue = serializer.serialize(value);

                redisConnection.set(redisKey, redisValue);
                return true;
            }
        });
    }

}
