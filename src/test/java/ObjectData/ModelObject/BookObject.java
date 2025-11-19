package ObjectData.ModelObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor //tine loc la contructor
@Data //tine loc la getter + setter cu ajutor Lombok

public class BookObject {

    private String isbn;

}
