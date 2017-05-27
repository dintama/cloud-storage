package cn.dintama.utils;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;


/**
 * Created by Dintama on 2017/5/27.
 */
public abstract class HDFSUtil {

    private static final String hdfsUrl = "hdfs://data.hope6537.com:9000";


    public static void updateHdfs(String filePath, String hdfsPath) throws  Exception {
        FileSystem fileSystem = FileSystem.get(new URI(hdfsUrl), new Configuration(), "root");
        InputStream inputStream = new FileInputStream(filePath);
        OutputStream outputStream = fileSystem.create(new Path(hdfsPath));
        IOUtils.copyBytes(inputStream, outputStream, 4096, true);

    }

    public static void downloadHdfs(String filePath, String hdfsPath) throws Exception{
        FileSystem fileSystem = FileSystem.get(new URI(hdfsUrl), new Configuration(), "root");
        InputStream inputStream = fileSystem.open(new Path(filePath));
        OutputStream outputStream = new FileOutputStream(hdfsPath);
        IOUtils.copyBytes(inputStream, outputStream, 4096, true);
    }

    public static void deleteHdfs(String hdfsPath) throws Exception{
        FileSystem fileSystem = FileSystem.get(new URI(hdfsUrl), new Configuration(), "root");
        fileSystem.delete(new Path(hdfsPath), true);
    }

    public static void main(String[] args) throws Exception {
        deleteHdfs("/test");
    }

}
