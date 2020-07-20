/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.forum.configuration;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Gabriel
 */
@Profile("dev")
@Configuration
public class GreenMailLocalSmtpConfiguration {

    private GreenMail smtpServer;
    
    @Value("${spring.mail.host}")
    private String hostAddress;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @PostConstruct
    public void setup() {
        ServerSetup serverSetup = new ServerSetup(Integer.parseInt(this.port), this.hostAddress, "smtp");
        this.smtpServer = new GreenMail(serverSetup);
        this.smtpServer.setUser(username, username, password);
        this.smtpServer.start();
    }

    @PreDestroy
    public void destroy() {
        this.smtpServer.stop();
    }

}
