package Tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountGetSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {

    public String userId;
    public String token;
    public RequestAccount requestAccountBody;
    public AccountActions accountActions;

    @Test
    public void testMethod(){
        System.out.println("Step 1: create new account");
        createAccount();
        System.out.println();

        System.out.println("Step 2: generate new token");
        generateToken();
        System.out.println();

        System.out.println(("Step 3: get new account"));
        getSpecificAccount();
        System.out.println();

        System.out.println(("Step 4: delete created new account"));
        deleteSpecificAccount();
        System.out.println();

        System.out.println(("Step 5: re-check that account was deleted"));
        getSpecificAccount();
        System.out.println();
    }

    public void createAccount(){
        accountActions = new AccountActions();
        //pregatim body-ul in functie de fisier Json pe care-l avem
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        //chemam layerul de AccountActions care trigaruieste layerele de mai jos: 1 si 2, face Post si returneaza
        //in obiectul specific ResponseAccountSucces, dupa care extram de pe el valoarea userId
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);
        userId = responseAccountBody.getUserID();
    }


    public void generateToken(){
         ResponseTokenSuccess responseTokenSuccess = accountActions.generateToken(requestAccountBody);
         token = responseTokenSuccess.getToken();
    }

    public void getSpecificAccount(){
        accountActions.getSpecificAccount(token, userId, requestAccountBody);
    }

    public void deleteSpecificAccount(){
        accountActions.deleteSpecificAccount(token, userId);
    }
}
