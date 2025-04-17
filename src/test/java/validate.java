import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validate {

    @Test
    public void testing(){

        RestAssured.baseURI = "https://api.weatherapi.com/v1/current.json";
        String cityname = "Chidambaram";
        String key = "e6a487d9f7a74f4197a23319251504";

        Response response = RestAssured.given()
                .queryParam("key",key)
                .queryParam("q",cityname)
                .queryParam("units","metric")
                .when().get();

        int status = response.getStatusCode();
        System.out.println("Status code :"+status);
        System.out.println("Body : "+response.asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected code is 200");

        String actual = response.jsonPath().getString("location.name");
        System.out.println("city : "+actual);
        Assert.assertEquals(actual,cityname);

    }
    @Test
    public void testing2() {

        RestAssured.baseURI = "https://api.weatherapi.com/v1/current.json";
        String cityname = "Chennai";
        String key = "e6a487d9f7a74f4197a23319251504";

        Response response = RestAssured.given()
                .queryParam("key", key)
                .queryParam("q", cityname)
                .queryParam("units", "metric")
                .when().get();

        int status = response.getStatusCode();
        System.out.println("Status code :" + status);
        System.out.println("Body : " + response.asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected code is 200");

        String actual = response.jsonPath().getString("location.name");
        System.out.println("city : " + actual);
        Assert.assertEquals(actual, cityname);
    }
}