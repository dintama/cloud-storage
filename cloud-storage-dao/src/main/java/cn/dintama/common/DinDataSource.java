package cn.dintama.common;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by Dintama on 2017/5/25.
 */
public class DinDataSource extends DruidDataSource {


    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
       super.setPassword(password);
    }

}
