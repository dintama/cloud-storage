package cn.dintama.controller;

import cn.dintama.utils.dto.UploadStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dintama on 2017/5/27.
 */
@Controller
public class WorkbenchController {


    @RequestMapping(value = "/index")
    public String index(){
        return "workbench/index";
    }


    @RequestMapping(value = "/file/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value="file",required= false) MultipartFile[] files,HttpServletRequest request) throws IOException {

        long  startTime=System.currentTimeMillis();
        String fileSavePath = request.getParameter("filelSavePath");
        File pathFile = new File("D:\\"+fileSavePath);

        if(!pathFile.exists()&&!pathFile.isDirectory()){
            pathFile.mkdirs();
        }
        if(files!=null&&files.length>0){
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                file.transferTo(new File("D:\\"+fileSavePath+"\\"+file.getOriginalFilename()));

            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法四的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success";
    }

    @RequestMapping(value = "/file/getStatus")
    @ResponseBody
    public UploadStatus getStatus(HttpSession session){
        System.out.println((UploadStatus)session.getAttribute("upload_status"));
        return (UploadStatus)session.getAttribute("upload_status");
    }

}
