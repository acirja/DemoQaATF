package Actions;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountGetFailed;
import ObjectData.ResponseObject.ResponseAccountGetSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import RestClient.ResponseStatus;
import Service.ServiceImplementation.AccountServiceImp;
import io.restassured.response.Response;
import org.testng.Assert;

public class AccountActions {

    private AccountServiceImp accountServiceImp;


    public AccountActions() {
        accountServiceImp = new AccountServiceImp();
    }

    //cream un cont nou, face assert si returneaza obiectul pentru ca mai tarziu vrem sa extragem anumite informatii de acolo
    public ResponseAccountSuccess createNewAccount(RequestAccount requestAccount){
        Response response = accountServiceImp.createAccount(requestAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_CREATED);
        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
        System.out.println(responseAccountBody.getUserID());
        Assert.assertEquals(responseAccountBody.getUsername(), requestAccount.getUserName());
        return responseAccountBody;
    }

    public ResponseTokenSuccess  generateToken(RequestAccount requestAccount){
        Response response = accountServiceImp.generateAccountToken(requestAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
        ResponseTokenSuccess responseTokenSuccess = response.body().as(ResponseTokenSuccess.class);
        Assert.assertEquals(responseTokenSuccess.getStatus(), "Success");
        Assert.assertEquals(responseTokenSuccess.getResult(), "User authorized successfully."); //
        return responseTokenSuccess;
    }

    public void getSpecificAccount(String token, String userId, RequestAccount requestAccountBody){
        Response response = accountServiceImp.getSpecificAccount(token, userId);
        if (response.getStatusCode() == ResponseStatus.SC_OK ){
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
            ResponseAccountGetSuccess responseAccountGetSuccess = response.body().as(ResponseAccountGetSuccess.class);
            Assert.assertEquals(responseAccountGetSuccess.getUsername(), requestAccountBody.getUserName());
        }
        else{
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_UNAUTHORIZED);
            ResponseAccountGetFailed responseAccountGetFailed = response.body().as(ResponseAccountGetFailed.class);
            Assert.assertEquals(responseAccountGetFailed.getCode(), "1207");
            Assert.assertEquals(responseAccountGetFailed.getMessage(), "User not found!"); //vs "User not authorized!" cum apare in swagger
        }
    }

    public void deleteSpecificAccount(String token, String userId){
        Response response = accountServiceImp.deleteSpecificAccount(token, userId);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_NO_CONTENT);
    }
}
