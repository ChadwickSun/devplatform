package com.cy.devp.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SimpleMailSender {
    private transient MailAuthenticator authenticator;
    private transient Session session;

    private void init() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", SmtpManage.cache.get("mail_host"));
        props.put("mail.smtp.port", SmtpManage.cache.get("mail_port"));
        authenticator = new MailAuthenticator(SmtpManage.cache.get("mail_name"), SmtpManage.cache.get("mail_psw"));
        session = Session.getInstance(props, authenticator);
    }

    public boolean send(String recipient, String subject, String content) {
        if (session == null) {
            init();
        }
        final MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(SmtpManage.cache.get("mail_sender")));
            Address from = new InternetAddress(recipient);
            message.setRecipient(Message.RecipientType.TO, from);
            message.setSubject(subject);
            Multipart mp = new MimeMultipart("related");
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent(content, "text/html;charset=utf-8");
            mp.addBodyPart(mbp);
            message.setContent(mp);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

/*    public void send(SimpleMail mail)
            throws MessagingException {
        send(mail.getToEmail(), mail.getSubject(), mail.getContent());
    }*/

}