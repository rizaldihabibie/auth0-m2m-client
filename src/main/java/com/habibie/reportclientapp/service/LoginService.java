/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.service;

import com.habibie.reportclientapp.data.Constant;
import com.habibie.reportclientapp.model.Auth0Response;
import com.habibie.reportclientapp.views.Home;
import com.habibie.reportclientapp.views.MainPanel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.http.HttpStatus;

/**
 *
 * @author Rizaldi Habibie
 */
public class LoginService {
    public boolean login(String clientId, String clientSecret, String audience){
        try{
            HttpResponse<String> response = Unirest.post("https://dev-ox3h99pl.us.auth0.com/oauth/token")
            .header("content-type", "application/json")
            .body("{\"client_id\":\""+clientId+"\",\"client_secret\":\""+clientSecret+"\",\"audience\":\""+audience+"\",\"grant_type\":\"client_credentials\"}")
            .asString();
            System.out.println(response.getStatus());
            System.out.println(response.getBody());
            if(response.getStatus() == HttpStatus.SC_OK){
                Gson gson = new Gson();
                Auth0Response authResponse = gson.fromJson(response.getBody(), Auth0Response.class);
                Constant.ACCESS_TOKEN = authResponse.getAccess_token();
                Constant.CLIENT_ID = clientId;
                Constant.AUDIENCE = audience;
                Constant.CLIENT_SECRET = clientSecret;
                System.out.println(Constant.ACCESS_TOKEN);
                return true;
            }else{
                return false;
            }
//            System.out.println(authResponse.getAccess_token());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean logout(){
        try{
            HttpResponse<String> response = Unirest.post("https://dev-ox3h99pl.us.auth0.com/v2/logout?client_id="+Constant.CLIENT_ID+"&returnTo=http%3A%2F%2Flocalhost%3A8080")
            .header("content-type", "application/json")
            .asString();
            System.out.println(response.getStatus());
            System.out.println(response.getBody());
//            if(response.getStatus() == HttpStatus.SC_OK){
//                Gson gson = new Gson();
//                Auth0Response authResponse = gson.fromJson(response.getBody(), Auth0Response.class);
//                Constant.ACCESS_TOKEN = authResponse.getAccess_token();
//                Constant.CLIENT_ID = clientId;
//                Constant.AUDIENCE = audience;
//                Constant.CLIENT_SECRET = clientSecret;
//                System.out.println(Constant.ACCESS_TOKEN);
//                return true;
//            }else{
                return false;
//            }
//            System.out.println(authResponse.getAccess_token());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
