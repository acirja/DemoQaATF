package Tests;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {
    @Test
    public void testMethod(){
        //definim configurarile pentru client
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com/");
        requestSpecification.contentType("application/json");

        //definim requestul
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData"); //incarcam requestul dinamic si l-am serializat sub forma unui obiect
        RequestAccount requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        requestSpecification.body(requestAccountBody.toString());

//        JSONObject createUserBody = new JSONObject();
//        createUserBody.put("userName", "TestAutomation" + System.currentTimeMillis());
//        createUserBody.put("password", "Password123!");


        //interactionam cu responsul
        Response response = requestSpecification.post("Account/v1/User");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        //validam response body-ul
       // ResponseBody responseBody = response.getBody();
        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);

        System.out.println(responseAccountBody.getUserID());
        Assert.assertEquals(responseAccountBody.getUsername(), responseAccountBody.getUsername());
    }

}
