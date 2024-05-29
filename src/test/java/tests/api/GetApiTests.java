package tests.api;

import baseEntities.BaseApiTest;
import configuration.ReadProperties;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;
import static java.nio.file.Paths.get;

public class GetApiTests extends BaseApiTest {

    @Test
    public void getProjectTest() {
        String endPoint = "/api/v1/project/1";

        given()
                .when()
                .get(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getUserInfoTest() {
        String endPoint = "/api/v1/account/me";

        given()
                .when()
                .get(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
