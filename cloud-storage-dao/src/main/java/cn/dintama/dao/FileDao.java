package cn.dintama.dao;

import cn.dintama.common.MybatisRepository;
import cn.dintama.entity.FileDo;

/**
 * Created by Dintama on 2017/5/30.
 */
@MybatisRepository
public interface FileDao {

    void insertFile(FileDo file);

    void insertDir(FileDo file);

}
