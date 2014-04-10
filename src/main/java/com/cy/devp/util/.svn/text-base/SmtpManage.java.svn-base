package com.cy.devp.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: liaoguoming
 * Date: 14-3-12
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public class SmtpManage {
    public static Map<String, String> cache = new HashMap<String, String>();
    public static void init() {
        if (cache.isEmpty()){
            InputStream ins = SmtpManage.class.getResourceAsStream("/mailConfig.properties");
            Properties p = new Properties();
            try {
                p.load(ins);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cache.put("mail_host", p.getProperty("mail_host"));
            cache.put("mail_port", p.getProperty("mail_port"));
            cache.put("mail_sender", p.getProperty("mail_sender"));
            cache.put("mail_name", p.getProperty("mail_name"));
            cache.put("mail_psw", p.getProperty("mail_psw"));
        }
    }
}
