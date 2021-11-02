/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.controller;

import com.habibie.reportclientapp.model.ApiResponse;
import com.habibie.reportclientapp.model.ReportIp;
import com.habibie.reportclientapp.service.LoginService;
import com.habibie.reportclientapp.service.ReportService;
import com.habibie.reportclientapp.views.Home;
import com.habibie.reportclientapp.views.MainPanel;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 *
 * @author Rizaldi Habibie
 */
public class MainController {
    private MainPanel mainPanel;
    private Home home;
    private ReportService reportService;
    private LoginService loginService;
    public MainController (Home home){
        this.home = home;
        init();
    }
    
    private void init(){
        mainPanel = new MainPanel();
        reportService = new ReportService();
        getIp();
        mainPanel.getSubmit().addActionListener(this::submitActionButton);
        loginService = new LoginService();
        mainPanel.getLogoutButton().addActionListener(this::logoutActionButton);
    }
    private void getIp(){
        try
        {
            InetAddress localhost = InetAddress.getLocalHost();
            mainPanel.getLocalIpAddress().setText(localhost.getHostAddress().trim());
            mainPanel.getLocalIpAddress().setEditable(false);
            
            // Find public IP address
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc =
            new BufferedReader(new InputStreamReader(url_name.openStream()));
  
            // reads system IPAddress
            mainPanel.getPublicIpAddress().setText(sc.readLine().trim());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public MainPanel getPanel(){
        return mainPanel;
    }
    
    public void submitActionButton(ActionEvent ae) {
        ApiResponse apiResponse = reportService.submitReport(mainPanel.getPublicIpAddress().getText().trim());
        if(apiResponse != null){
            mainPanel.getReportStatus().setText(apiResponse.getMessage());
            Gson gson = new Gson();
            ReportIp reportIp = gson.fromJson(apiResponse.getData().toString(), ReportIp.class);
            mainPanel.getSubmittedIp().setText(reportIp.getIp());
            mainPanel.getDetectedIp().setText(reportIp.getDetectedIp());
        }else{
            mainPanel.getReportStatus().setText("ERROR");
            mainPanel.getSubmittedIp().setText("");
            mainPanel.getDetectedIp().setText("");            
        }
    }
    
    public void logoutActionButton(ActionEvent ae) {
        loginService.logout();
    }
}
