package com.farmdigital.nerddevs.Mails;

import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
@RequiredArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public  void SendEmail(String  email,String  subject,String  content) throws MessagingException, UnsupportedEncodingException {
          String  senderemail="challykiddoh@gmail.com";
        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(senderemail,"Agri-connect ");
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(content,true);

        mailSender.send(message);



    }
}
