package ObjectData.RequestObject;

import ObjectData.RequestPreparation;
import lombok.Data;

import java.util.HashMap;

@Data

public class RequestAccount implements RequestPreparation {

    private String userName;
    private String password;

    public RequestAccount(HashMap<String, String> testData){
        prepareObject(testData);
    }

    @Override
    public void prepareObject(HashMap<String, String> testData) {
        for (String key: testData.keySet()){ //rolul for-ului este de a mapa tot ce avem in fisier pe acest obiect
            switch (key){
                case "userName":
                    setUserName(testData.get(key));
                    break;

                case "password":
                    setPassword(testData.get(password));
                    break;
            }
        }
        adjustObjectVariable();
    }

    private void adjustObjectVariable(){
        userName = userName + System.currentTimeMillis();
    }

}
