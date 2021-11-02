/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.controller;

import com.habibie.reportclientapp.service.LoginService;
import com.habibie.reportclientapp.views.FormLogin;
import com.habibie.reportclientapp.views.Home;
import com.habibie.reportclientapp.views.LoginPanel;
import com.habibie.reportclientapp.views.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rizaldi Habibie
 */
public class LoginController {
    private LoginService loginService;
    private FormLogin formLogin;
    private LoginPanel loginPanel;
    private Home home;
    
    public LoginController(Home home){
        this.home = home;
        init();
    }
    
    public void init(){
        loginService = new LoginService();
        formLogin = new FormLogin(home, true);
        loginPanel = new LoginPanel(home);
        loginPanel.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                formLogin.setVisible(true);
            }
        });
        formLogin.getLoginButton().addActionListener(this::loginActionButton);
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
    
    public void loginActionButton(ActionEvent ae) {
        if(loginService.login(formLogin.getClientId().getText(),
                formLogin.getClientSecret().getText(),
                formLogin.getAudience().getText())){
            System.out.println("Login Success");
            
            MainController mainController = new MainController(home);
            home.setPanel(mainController.getPanel());
            formLogin.setVisible(false);
        }else{
            formLogin.getMessage().setText("Sorry, Something went wrong.");
        }
    }
    
}
