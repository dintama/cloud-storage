package cn.dintama.dao;

import cn.dintama.entity.User;
import cn.dintama.service.UserService;
import cn.dintama.test.helper.SpringTestHelper;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * Created by Dintama on 2017/5/25.
 */
@ContextConfiguration("classpath:spring/spring-service-impl-context.xml")
public class UserTest extends SpringTestHelper {

    @Resource
    private UserService userService;


    @Test
    public void testGetUserByEmail(){
        User userByEmail = userService.getUserByEmail("dingyi6680@qq.com");
        System.out.println(userByEmail.toString());
    }

    @Test
    public void testValidateLogin(){
        Boolean aBoolean = userService.validateLogin(null);
        System.out.println(aBoolean);
    }

}
