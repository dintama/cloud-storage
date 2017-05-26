package cn.dintama.test.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

/**
 * Created by Dintama on 2017/5/25.
 */
public abstract class SpringTestHelper extends AbstractTransactionalJUnit4SpringContextTests {

    protected DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
        this.dataSource = dataSource;
    }
}