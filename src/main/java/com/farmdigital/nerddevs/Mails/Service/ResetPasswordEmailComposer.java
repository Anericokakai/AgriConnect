package com.farmdigital.nerddevs.Mails.Service;

import com.farmdigital.nerddevs.Registration.security.JwtServices;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ResetPasswordEmailComposer {
    private final JwtServices jwtServices;
    private final JavaMailSenderImpl mailSender;


    public void sendResetPasswordEmail(String email, String name) {
        String subject = "  \uD83D\uDD10 Change your Agri-connect password";
        String token = jwtServices.generateAtokenWithoutUserdetails(new HashMap<>(), email);

        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <link\n" +
                "      href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;1,300;1,400&family=Roboto:ital,wght@0,300;0,400;0,500;1,100;1,400&display=swap\"\n" +
                "      rel=\"stylesheet\"\n" +
                "    />\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "  </head>\n" +
                "\n" +
                "  <body style=\"font-family: 'Poppins', sans-serif; color: rgba(9, 9, 9, 0.874);         " +
                "  background-color: #f7f7f7;\">\n" +
                "    \n" +
                "    <section\n" +
                "      style=\"\n" +

                "        max-width: 500px;\n" +
                "        box-shadow: 0px 24px 38px 3px rgba(233, 229, 229, 0.028),\n" +
                "          0px 9px 46px 8px rgba(178, 176, 176, 0.041),\n" +
                "          0px 11px 15px -7px rgba(0, 0, 0, 0.079);\n" +
                "        border-radius: 5px;\n" +
                "        margin: 0 auto;\n" +
                "        padding: 1em;\n" +
                "        text-align: center;\n" +
                "        line-height: 1.5em;" +
                "background-color: #ffffff;\n" +
                "      \"\n" +
                "    >\n" +
                "      <img\n" +
                "        style=\"height: 150px\"\n" +
                "        src=\"https://res.cloudinary.com/dlobwfi13/image/upload/v1700778228/upbobhxttjpoo2qzypgw.png\"\n" +
                "        alt=\"message icon\"\n" +
                "        =\"height: 100px\"\n" +
                "      />\n" +
                "      <h4 style=\"color: #24820f; font-size: 20px; padding: 10px 0\">\n" +
                "        \uD83D\uDCE9 Reset your Agri-connect password\n" +
                "      </h4>\n" +
                "      <!-- #; -->\n" +
                "      <p style=\"text-align: left; line-height: 1.7em; font-size: 17px\">\n" +
                "        Hello , " + name + " , Click the link below to change your password .The link\n" +
                "        will expire in one hour\n" +
                "      </p>\n" +
                "      <a href=\"\"\n" +
                "        ><button\n" +
                "          style=\"http://localhost:8080/api/v1/farm_digital/super/user/forgot_password/reset?token="+token+"\n" +
                "            color: white;\n" +
                "            background-color: #24820f;\n" +
                "            padding: 0.7em 2em;\n" +
                "            border: none;\n" +
                "            box-shadow: 0px 20px 25px -5px rgba(0,0,0,0.1) , 0px 10px 10px -5px rgba(0,0,0,0.04) ;\n" +
                "            border-radius: 5px;\n" +
                "            cursor: pointer;\n" +
                "            margin: 1.5em 0;\n" +
                "          \"\n" +
                "        >\n" +
                "          change your password\n" +
                "        </button></a\n" +
                "      >\n" +
                "      <p style=\"text-align: left; line-height: 1.7em; font-size: 17px\">\n" +
                "        Agri-connect is a platform that helps farmers connect with customers .\n" +
                "      </p>\n" +
                "      <strong style=\"font-size: 17px;\">Agri-connect Benefits</strong>\n" +
                "      <ul style=\"list-style-type: square; text-align: left\">\n" +
                "        <li style=\"margin: 1em 0 ;font-size: 17px;\">\n" +
                "          Helps farmers find better prices for their products\n" +
                "        </li>\n" +
                "        <li style=\"margin: 1em 0 ;font-size: 17px;\">enables farmers to explore new markets</li>\n" +
                "        <li style=\"margin: 1em 0 ;font-size: 17px;\">\n" +
                "          It gives farmers market information on the prices and farm produce\n" +
                "          that are on demand in the market\n" +
                "        </li>\n" +
                "        <li style=\"margin: 1em 0 ;font-size: 17px;\">\n" +
                "          Alerts farmers on the weather, the best crops to grow in their areas\n" +
                "        </li>\n" +
                "      </ul>\n" +
                "      <p style=\"font-weight: bold ; text-align: left;\">All the best</p>\n" +
                "      <p style=\"text-align: left;  font-size: 17px;padding: 0; margin: 0;\">\n" +
                "        The Nerds developers\n" +
                "      </p>\n" +
                "      <p style=\"text-align: left; font-size: 17px\">\n" +
                "        Follow us on our social platforms\n" +
                "      </p>\n" +
                "      <div\n" +
                "        style=\"\n" +
                "          margin-top: 1em;\n" +
                "          display: flex;\n" +
                "          align-items: center;\n" +
                "          justify-content: center;\n" +
                "          gap: 1em;\n" +
                "        \"\n" +
                "      >\n" +
                "        <a href=\"https://www.linkedin.com/in/anerico-kakai-600b80258/\"\n" +
                "          ><img\n" +
                "            style=\"width: 40px;margin: 10px;\"\n" +
                "            src=\"https://res.cloudinary.com/dlobwfi13/image/upload/v1700779166/zdspebb7rhdme0aiw0xy.png\"\n" +
                "            alt=\"linked in icon\"\n" +
                "        /></a>\n" +
                "        <a href=\"https://twitter.com/nerdevK\"\n" +
                "          ><img\n" +
                "            style=\"width: 40px;margin: 10px;\"\n" +
                "            src=\"https://res.cloudinary.com/dlobwfi13/image/upload/v1700779626/tnitmtgsfamuufuglqel.png\"\n" +
                "            alt=\"X  icon\"\n" +
                "        /></a>\n" +
                "        <a href=\"https://www.instagram.com/r.ic.o_k/\"\n" +
                "          ><img\n" +
                "            style=\"width: 40px;margin: 10px;\"\n" +
                "            src=\"https://res.cloudinary.com/dlobwfi13/image/upload/v1700779703/uxun92f3q2tnewafvvfs.png\"\n" +
                "            alt=\"instagram in icon\"\n" +
                "        /></a>\n" +
                "        <a href=\"\"\n" +
                "          ><img\n" +
                "            style=\"width: 40px;margin: 10px;\"\n" +
                "            src=\" https://res.cloudinary.com/dlobwfi13/image/upload/v1700779786/xdyw2bl83fmpidgbcnaw.png\"\n" +
                "            alt=\"you tube in icon\"\n" +
                "        /></a>\n" +
                "      </div>\n" +
                "      <footer style=\"margin-top: 1em\">\n" +
                "        <a style=\"padding:3px ; text-decoration: underline ;color: blueviolet;\" href=\"\"><small>Contact us</small></a>\n" +
                "        <a style=\"padding:3px ; text-decoration: underline ;color: blueviolet;\" href=\"\"><small>Term and Conditions</small></a>\n" +
                "        <a style=\"padding:3px ; text-decoration: underline ;color: blueviolet;\" href=\"\"><small>License and policy</small></a>\n" +
                "      </footer>\n" +
                "    </section>\n" +
                "  </body>\n" +
                "</html>\n";

        try {
            EmailService emailService = new EmailService(mailSender);
            emailService.SendEmail(email, subject, content);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            System.out.println("failed to send email to the user");

        }

    }
}
