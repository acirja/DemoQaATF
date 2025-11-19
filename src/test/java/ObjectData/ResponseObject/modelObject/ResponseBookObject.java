package ObjectData.ResponseObject.modelObject;

import ObjectData.ResponseNotNull;
import com.aventstack.extentreports.util.Assert;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter

public class ResponseBookObject implements ResponseNotNull {


    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("title")
    private String title;

    @JsonProperty("subTitle")
    private String subTitle;

    @JsonProperty("author")
    private String author;

    @JsonProperty("publish_data")
    private String publishData;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("pages")
    private Integer pages;

    @JsonProperty("description")
    private String description;

    @JsonProperty("website")
    private String website;

    @Override
    public void validatedNotNullFields() {
        if (title != null){
            Assert.assertNotNull(isbn);
            Assert.assertNotNull(title);
            Assert.assertNotNull(subTitle);
            Assert.assertNotNull(author);
            Assert.assertNotNull(publishData);
            Assert.assertNotNull(publisher);
            Assert.assertNotNull(pages);
            Assert.assertNotNull(description);
            Assert.assertNotNull(website);
        }

    }
}