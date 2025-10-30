package Service;

import RestClient.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import RestClient.RequestType;

public class CommonApiService {

    //LAYER 2 - presupune definerea actiunilor care se vor face pe configurarile de client (LAYER 1)

    public Response post(Object body, String endpoint){
        RequestSpecification requestSpecification = RestAssured.given();
        //pentru acest tip de metoda o sa facem un POST cu un body
        requestSpecification.body(body);
        Response response = performRequest(RequestType.REQUEST_POST, requestSpecification, endpoint);
        return response;
    }

    public Response get(String token, String endPoint){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer"+ token);
        Response response = performRequest(RequestType.REQUEST_GET, requestSpecification, endPoint);
        return response;
    }

    //metoda care instantiaza legatura cu layer 1
    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint){
        return new RestClient().performRequest(requestType, requestSpecification, endPoint);
    }
}
