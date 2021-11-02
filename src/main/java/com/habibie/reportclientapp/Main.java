/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp;

import com.habibie.reportclientapp.controller.HomeController;
import com.habibie.reportclientapp.data.Constant;
import com.habibie.reportclientapp.views.Home;

/**
 *
 * @author Rizaldi Habibie
 */
public class Main {
    public static void main (String[] args){
        if(args.length>0 && (null != args[0] && !"".equals(args[0]))){
            Constant.SERVER_URL=args[0];
        }else{
            Constant.SERVER_URL="http://localhost:8080";
        }
        System.setProperty("java.awt.headless", "false"); //Disables headless
        HomeController mainController = new HomeController();
        mainController.run();
    }
}
