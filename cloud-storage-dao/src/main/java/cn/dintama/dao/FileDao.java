package cn.dintama.dao;

import cn.dintama.common.MybatisRepository;
import cn.dintama.entity.FileDo;

import java.util.List;

/**
 * Created by Dintama on 2017/5/30.
 */
@MybatisRepository
public interface FileDao {

    void insertFile(FileDo file);

    void insertDir(FileDo file);

    List<FileDo> selectAllFileListPage(FileDo file);



}
