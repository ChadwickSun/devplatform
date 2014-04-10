package com.cy.devp.controller;

import com.cy.devp.util.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: liaoguoming
 * Date: 14-4-9
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/app")
public class AppController {
    @RequestMapping(value = "/appCommit", method = RequestMethod.POST)
    @ResponseBody
    public String appCommit(HttpServletRequest request, @RequestParam MultipartFile[] appFiles) {

        String result = FileUpload.fileUpload(request, appFiles);
        return "";
    }

}
