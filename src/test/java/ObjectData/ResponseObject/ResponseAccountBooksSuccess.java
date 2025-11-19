package ObjectData.ResponseObject;

import ObjectData.ResponseNotNull;
import ObjectData.ResponseObject.modelObject.ResponseBookObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

import java.util.List;

@Getter

public class ResponseAccountBooksSuccess implements ResponseNotNull {

    @JsonProperty("books")
    private List<ResponseBookObject> books;

    @Override
    public void validatedNotNullFields() {
        for (ResponseBookObject responseBookObject : books) {
            responseBookObject.validatedNotNullFields();
        }
    }

    public void validateBooks(List<ResponseBookObject> actualValues){
        for (int index=0; index<books.size(); index++){
            Assert.assertEquals(actualValues.get(index).getIsbn(), books.get(index).getIsbn());
        }
    }
}
