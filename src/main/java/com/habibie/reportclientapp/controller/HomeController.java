/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.controller;

import com.habibie.reportclientapp.data.Constant;
import com.habibie.reportclientapp.views.Home;
import com.habibie.reportclientapp.views.LoginPanel;
import com.habibie.reportclientapp.views.MainPanel;

/**
 *
 * @author Rizaldi Habibie
 */
public class HomeController {
    private Home home;
    private LoginController loginController;
    private MainController mainController;
    
    public void run(){
        home = new Home();
        if(null == Constant.ACCESS_TOKEN){
            loginController = new LoginController(home);
            home.setPanel(loginController.getLoginPanel());
        }else{
            mainController = new MainController(home);
            home.setPanel(mainController.getPanel());
        }
        home.setVisible(true);
    }
   
}
