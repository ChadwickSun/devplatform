package com.cy.devp.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: liaoguoming
 * Date: 14-4-9
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
public class FileUpload {
    public static String fileUpload(HttpServletRequest request, MultipartFile[] appFiles) {
        String message = "文件上传成功";
        HttpSession session = request.getSession();
        String savePath = session.getServletContext().getRealPath("/") + "attached/";
        boolean flag = true;
        for (MultipartFile myfile : appFiles) {
            if (myfile.isEmpty()) {
                flag = false;
                message = "请选择上传文件";
            }
        }
        if (flag) {
            for (MultipartFile myfile : appFiles) {
                File localFile = new File(savePath + myfile.getOriginalFilename());
                try {
                    myfile.transferTo(localFile);
                } catch (IOException e) {
                    message = "文件上传失败";
                    e.printStackTrace();
                }
            }
        }
        return message;
    }
}
