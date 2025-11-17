package ObjectData.RequestObject;

import ObjectData.BookObject;
import ObjectData.RequestPreparation;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestAccountBooks implements RequestPreparation {

    private String useId;
    private List<BookObject> collectionOfIsbns;

    public RequestAccountBooks(HashMap<String, String> testData){
        prepareObject(testData);
    }

    @Override
    public void prepareObject(HashMap<String, String> testData) {
        for (String key: testData.keySet()){ //rolul for-ului este de a mapa tot ce avem in fisier pe acest obiect
            switch (key){
                case "userId":
                    setUseId(testData.get(key));
                    break;

                case "collectionOfIsbns":
                    prepareBooks(testData.get(key));
                    break;
            }
        }
    }

    //trebuie sa parsam valoarea pentru carti intr-o lista de obiecte (BookObject)
    private void prepareBooks(String value){
        collectionOfIsbns = new ArrayList<>();
        String[] books = value.split(",");
        for (int i=0; i<books.length; i++){
            collectionOfIsbns.add(new BookObject(books[i]));
        }
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public List<BookObject> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<BookObject> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
