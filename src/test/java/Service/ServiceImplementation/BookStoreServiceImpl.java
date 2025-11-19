package Service.ServiceImplementation;

import ObjectData.RequestObject.RequestAccountBooks;
import Service.ApiService.AccountApiService;
import Service.ApiService.BookStoreApiService;
import Service.InterfaceService.BookStoreServiceInterface;
import io.restassured.response.Response;

public class BookStoreServiceImpl implements BookStoreServiceInterface {

    private BookStoreApiService bookStoreApiService;
    @Override
    public Response addBooksToAccount(RequestAccountBooks body, String token) {
        bookStoreApiService = new BookStoreApiService();
        return bookStoreApiService.post(body, "BookStore/v1/Books", token);
    }

    @Override
    public Response updatedSpecificBook() {
        return null;
    }

    @Override
    public Response deleteSpecificBook() {
        return null;
    }

    @Override
    public Response deleteBook() {
        return null;
    }
}
