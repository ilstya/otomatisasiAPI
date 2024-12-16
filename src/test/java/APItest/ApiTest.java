package APItest;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.ApiRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    ApiRequest apiRequest = new ApiRequest();

    //positif
    @Test
    public void testGetRequestPositive() throws Exception {
        String response = apiRequest.sendGetRequest("https://jsonplaceholder.typicode.com/posts/1");
        Assert.assertTrue(response.contains("userId"), "terdapat 'userId'");
    }
}
