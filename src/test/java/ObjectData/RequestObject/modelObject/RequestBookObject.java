package ObjectData.RequestObject.modelObject;

import ObjectData.ResponseNotNull;
import com.aventstack.extentreports.util.Assert;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor //tine loc la contructor
@Data //tine loc la getter + setter cu ajutor Lombok

public class RequestBookObject implements ResponseNotNull {

    @JsonProperty("isbn")
    private String isbn;

    @Override
    public void validatedNotNullFields() {
        Assert.assertNotNull(isbn);
    }
}
