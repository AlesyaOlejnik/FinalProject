package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApiTests extends BaseApiTest {

    @Test
    public void getProjectTest() {
        String endPoint = "/api/v1/project/1000";

        given()
                .when()
                .get(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void getTestPlanTest() {
        String endPoint = "/api/v1/testplan";
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
