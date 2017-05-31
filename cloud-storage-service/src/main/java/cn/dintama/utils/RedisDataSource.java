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

    public boolean hSet(final String key, final String field,  final String value) {

        return redisTemplate.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                if (key == null) {
                    return false;
                }

                byte[] redisKey = serializer.serialize(key);
                byte[] redisField = serializer.serialize(field);
                byte[] redisValue = serializer.serialize(value);

                return connection.hSet(redisKey,redisField, redisValue);
            }
        });
    }


    public String hGet(final String key, final String field) {
        try {
            String value = redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    // TODO Auto-generated method stub

                    RedisSerializer<String> serializer = redisTemplate
                            .getStringSerializer();
                    byte[] redisKey = serializer.serialize(key);
                    byte[] redisField = serializer.serialize(field);
                    return serializer.deserialize(connection.hGet(redisKey,
                            redisField));
                }
            });
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            // throw new ServiceException(
            // "Fail to query keys from redis server. Caused By: "
            // + e.getMessage());
            logger.error("Fail to hget frm redis server, Caused by: ", e);
            return null;
        }
    }

}
