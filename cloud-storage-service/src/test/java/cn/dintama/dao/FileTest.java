package cn.dintama.dao;

import cn.dintama.entity.FileDo;
import cn.dintama.test.helper.SpringTestHelper;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * Created by Dintama on 2017/5/30.
 */
@ContextConfiguration("classpath:spring/spring-service-impl-context.xml")
public class FileTest extends SpringTestHelper{

    @Resource
    private FileDao fileDao;

    @Test
    public void testInsertFile(){
        FileDo fileDo = new FileDo();
        fileDo.setUserId(1);
        fileDo.setParentId(-1);
        fileDo.setFileName("test");
        fileDo.setFileSize(2.0);
        fileDo.setFileType(1);
        fileDao.insertFile(fileDo);
    }

}
