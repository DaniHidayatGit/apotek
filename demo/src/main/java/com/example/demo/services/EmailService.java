package com.example.demo.services;

import com.example.demo.dto.MallResponse;
import com.example.demo.dto.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.sender = mailSender;
    }

    public MallResponse sendEmail(MallService request){
        MallResponse response = new MallResponse();
        MimeMessage message = sender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setFrom("mitairuz1210@gmail.com");
            helper.setText(request.getText());
            sender.send(message);

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
