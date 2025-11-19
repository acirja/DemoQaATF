package ObjectData.ResponseObject;

import ObjectData.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter

public class ResponseAccountSuccess {

    @JsonProperty("userID")
    private String userID;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<BookObject> books;
}
