/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.reportclientapp.service;

import com.habibie.reportclientapp.data.Constant;
import com.habibie.reportclientapp.model.ApiResponse;
import com.habibie.reportclientapp.model.Auth0Response;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;

/**
 *
 * @author Rizaldi Habibie
 */
public class ReportService {
    
    public ApiResponse submitReport(String ipAddress){
        try{
            HttpResponse<String> response = Unirest.post(Constant.SERVER_URL+"/demo/report")
            .header("content-type", "application/json")
            .header("authorization", "Bearer "+Constant.ACCESS_TOKEN)
            .body("{\"id\":\""+Constant.CLIENT_ID+"\",\"ip\":\""+ipAddress+"\"}")
            .asString();
            System.out.println(response.getBody());
            System.out.println(response.getStatus());
            if(response.getStatus() == HttpStatus.SC_OK){
                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(response.getBody(), ApiResponse.class);
                return apiResponse;
            }
        }catch(JsonSyntaxException | UnirestException e){
            e.printStackTrace();
        }
        return null;
    }
}
