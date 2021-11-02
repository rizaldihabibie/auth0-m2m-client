/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.views;

import com.habibie.reportclientapp.service.LoginService;
import javax.swing.JButton;

/**
 *
 * @author Rizaldi Habibie
 */
public class LoginPanel extends javax.swing.JPanel {
    private Home home;
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel(Home home) {
        initComponents();
        this.home = home;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Hello, please login first");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));

        loginButton.setText("LOGIN");
        add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
