package cn.dintama.dao;

import cn.dintama.common.MybatisRepository;
import cn.dintama.entity.User;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Dintama on 2017/5/25.
 */
@MybatisRepository
public interface UserDao {

    void insertUser(User user);

    User selectUserByEmail(@Param("email")String email);

}
