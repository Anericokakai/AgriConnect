package com.farmdigital.nerddevs.Registration.views;

import org.springframework.stereotype.Service;

@Service
public class ExceptionMessage {

    public  String  sendBackError( String  reason){
         String exceptionHtml = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"https://www.thymeleaf.org\" lang=\"en\">\n" +
                "<head>\n" +
                "    <title>reset password</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />\n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />\n" +
                "    <link\n" +
                "            href=\"https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,opsz,wght@0,6..12,300;0,6..12,400;0,6..12,500;0,6..12,600;0,6..12,700;1,6..12,200;1,6..12,300;1,6..12,400&family=Poppins:ital,wght@0,300;0,400;0,500;1,300;1,400&family=Roboto:ital,wght@0,300;0,400;0,500;1,100;1,400&display=swap\"\n" +
                "            rel=\"stylesheet\"\n" +
                "    />\n" +
                "</head>\n" +
                "<body style=\"text-align: center \">\n" +
                "\n" +
                "\n" +
                "<h1 style=\"margin-top: 5em\">There was an error while updating your password ! </h1>\n" +
                 "<p> the reason is that "+ reason+"</p>"+
                "<p> click this link to try  again <a href=\"http://localhost:8080/api/v1/agri_connect/super/user/authenticate\"> retry </a>  </p>\n" +
                "</body>\n" +
                "<style>\n" +
                "    *{\n" +
                "        font-family: \"Nunito Sans\", sans-serif;\n" +
                "    }\n" +
                "</style>\n" +
                "</html>";
        return exceptionHtml;

    }

}
