
import com.habibie.reportclientapp.data.Constant;
import com.habibie.reportclientapp.model.ApiResponse;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizaldi Habibie
 */
public class ServerTest {
    
    @Test
    public void testServerConnection() throws Exception{
        HttpResponse<String> response = Unirest.post("http://localhost:8080/demo/report")
        .header("content-type", "application/json")
        .header("authorization", "Bearer "+Constant.ACCESS_TOKEN)
        .body("{\"id\":\""+Constant.CLIENT_ID+"\",\"ip\":\"this is ip\"}")
        .asString();
        Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
    }
}
