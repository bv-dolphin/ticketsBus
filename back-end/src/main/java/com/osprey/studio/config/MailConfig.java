package com.osprey.studio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Value("$(host)")
    private String host;

    @Value("${username}")
    private String username;

    @Value("${port}")
    private int port;

    @Value("${protocol}")
    private String protocol;

    @Value("${password}")
    private String password;

    @Value("${debug}")
    private String debug;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("protocol", protocol);


        return mailSender;


    }
}
