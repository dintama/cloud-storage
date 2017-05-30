package cn.dintama.controller;

import cn.dintama.dao.FileDao;
import cn.dintama.entity.FileDo;
import cn.dintama.entity.User;
import cn.dintama.utils.HDFSUtil;
import cn.dintama.utils.dto.UploadStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dintama on 2017/5/27.
 */
@Controller
public class WorkbenchController {


    @Resource
    private FileDao fileDao;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("nickname", user.getNickname());
        return "workbench/index";
    }


    @RequestMapping(value = "/file/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value="file",required= false) MultipartFile[] files,HttpServletRequest request) throws IOException {

        DecimalFormat df = new DecimalFormat("######0.00");

        String curTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File pathFile = new File("D:\\CloudStorageFile\\"+curTime);

        Integer parentId = Integer.parseInt(request.getParameter("pathId"));

        User user = (User)request.getSession().getAttribute("user");
        if(user == null || user.getEmail() == null || user.getEmail() == ""){
            return "failed";
        }

        String email = user.getEmail();

        String hdfsPath = "/cloud-storage/" + email + "/";

        if(!pathFile.exists()&&!pathFile.isDirectory()){
            pathFile.mkdirs();
        }
        if(files!=null&&files.length>0){
            for(int i = 0;i<files.length;i++){

                MultipartFile file = files[i];

                String tmpFileName = new BASE64Encoder().encode((email + file.getOriginalFilename()).getBytes());
                String filePath = "D:\\CloudStorageFile\\"+curTime+"\\"+tmpFileName;

                file.transferTo(new File(filePath));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HDFSUtil.updateHdfs(filePath, hdfsPath + file.getOriginalFilename());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                //FileDo构造
                FileDo fileDo = new FileDo();
                fileDo.setUserId(user.getId());
                fileDo.setParentId(parentId);
                fileDo.setFileName(file.getOriginalFilename());
                fileDo.setHdfsPath(hdfsPath + file.getOriginalFilename());
                long size = file.getSize();
                double finalSize = size / 1048576.0;
                fileDo.setFileSize(Double.parseDouble(df.format(finalSize)));

                fileDao.insertFile(fileDo);

            }
        }
        return "success";
    }

    @RequestMapping(value = "/file/getStatus")
    @ResponseBody
    public UploadStatus getStatus(HttpSession session){
        System.out.println((UploadStatus)session.getAttribute("upload_status"));
        return (UploadStatus)session.getAttribute("upload_status");
    }

    @RequestMapping(value = "/file/createDir")
    @ResponseBody
    public void createDir(HttpServletRequest request, FileDo fileDo){
        fileDao.insertDir(fileDo);
    }

}
