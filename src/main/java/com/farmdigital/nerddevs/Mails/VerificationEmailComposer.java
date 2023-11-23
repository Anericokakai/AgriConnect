package com.farmdigital.nerddevs.Mails;

import com.farmdigital.nerddevs.security.JwtServices;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class VerificationEmailComposer {
    private final JavaMailSenderImpl mailSender;
    private  final JwtServices jwtServices;
//hello

    public String  sendVerificationEmail(String  email){
        String  token=jwtServices.generateAtokenWithoutUserdetails(new HashMap<>(),email);

    String Subject = "Verify your Agri-connect account";
    String  content= " <!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Document</title>\n" +
            "    <link\n" +
            "    rel=\"stylesheet\"\n" +
            "    href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css\"\n" +
            "  />\n" +
            "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
            "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
            "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;1,300;1,400&family=Roboto:ital,wght@0,300;0,400;0,500;1,100;1,400&display=swap\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body style=\"font-family: 'Poppins', sans-serif; text-align: center; padding: 10px;\">\n" +
            "    <section>\n" +
            "<img src='https://res.cloudinary.com/dlobwfi13/image/upload/v1700778228/upbobhxttjpoo2qzypgw.png' alt=\"message icon\" style=\"height: 100px;\">"+
            "        <h4 style=\"padding-bottom: 10px;\">Thanks for joining Agri-connect </h4>\n" +
            "\n" +
            "<p style=\"text-align: left;\">To complete your profile we need you to confirm your email address for more communications </p>\n" +
            "<a href=\"http://localhost:8080/api/v1/agri_connect/verify/account_verification?token="+token+"\"><button style=\"padding: .7em 2em; background-color: #24820f; color: white; cursor: pointer; border: none; \" >confirm my email address</button></a>\n" +
            "<p style=\"text-align: left;\"> Agri-connect is a platform that helps farmers connect with customers from different places and  explore new markets , find better prices for their  products . It gives farmers market information on the prices and farm produce that are on demand in the market</p>\n" +
            "<p >All the best</p>\n" +
            "<p>The Nerds developers</p>\n" +
            "<div style=\"text-align: center; display: flex; align-items: center; justify-content: center; gap: 2em; flex-wrap: wrap;\">\n" +
            "<a style='margin:20px' href='https://www.linkedin.com/in/anerico-kakai-600b80258/'><img src='https://res.cloudinary.com/dlobwfi13/image/upload/v1700779166/zdspebb7rhdme0aiw0xy.png' alt=\"linked in icon\" style=\"height: 40px;cursor: pointer;\"></a>\n" +
            "<a href='https://twitter.com/nerdevK'style='margin:20px' ><img src='https://res.cloudinary.com/dlobwfi13/image/upload/v1700779626/tnitmtgsfamuufuglqel.png' alt=\"X  icon\" style=\"height: 40px;cursor: pointer;\"></a>\n"+
            "<a href='https://www.instagram.com/r.ic.o_k/'style='margin:20px' ><img src='https://res.cloudinary.com/dlobwfi13/image/upload/v1700779703/uxun92f3q2tnewafvvfs.png' alt=\"instagram in icon\" style=\"height: 40px; cursor: pointer;\"></a>\n"+
            "<a href=''style='margin:20px' ><img src='https://res.cloudinary.com/dlobwfi13/image/upload/v1700779786/xdyw2bl83fmpidgbcnaw.png' alt=\"you tube in icon\" style=\"height: 40px; cursor: pointer;\"></a>\n"+

            "</div>\n" +
            "    </section>\n" +
            "\n" +
            "    \n" +
            "</body>\n" +
            "</html>";
    try{
        EmailService emailService = new EmailService(mailSender);
         emailService.SendEmail(email,Subject,content);
         return  "email was sent successfully";
    } catch (MessagingException| UnsupportedEncodingException ex){
        System.out.println("failed to send the email "+ ex.getMessage());
        return  "un error occurred while sending the email address";
    }


}


}
