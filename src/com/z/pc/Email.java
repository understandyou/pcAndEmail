package com.z.pc;

import com.sun.mail.auth.MD4;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public void sendEmail() throws MessagingException {
        //用于创建session
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        prop.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
        prop.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        //包含发送的一些信息
        Session session = Session.getInstance(prop);
        session.setDebug(true);//调试模式
        //创建邮件内容对象
        MimeMessage message = new MimeMessage(session);
        message.setHeader("header","header");
        message.setSubject("这是头","UTF-8");
        message.setText("这是text内容","UTF-8");
        message.setFrom(new InternetAddress("fengyuyjiu@163.com"));//发送者
        message.setRecipients(Message.RecipientType.TO,"understandyou9958@qq.com");//接受者和发送方式

        Transport transport =  session.getTransport();
        transport.connect("fengyuyjiu@163.com","mailkey123");
        transport.sendMessage(message,message.getAllRecipients());


    }

    public static void main(String[] args) {
        Email em = new Email();
        try {
            em.sendEmail();
            System.out.println("发送ok");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
