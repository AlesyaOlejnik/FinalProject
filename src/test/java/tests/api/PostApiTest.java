package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    @Test
    public void createProjectTest() {
        String endPoint = "/api/v1/project";

        given()
                .body(String.format("{\n" +
                        "  \"id\": 4,\n" +
                        "  \"is_deleted\": true,\n" +
                        "  \"created_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                        "  \"created_by\": 0,\n" +
                        "  \"modified_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                        "  \"modified_by\": 0,\n" +
                        "  \"deleted_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                        "  \"deleted_by\": 0,\n" +
                        "  \"_etag\": \"string\",\n" +
                        "  \"owner_user_id\": 0,\n" +
                        "  \"name\": \"ApiProject\",\n" +
                        "  \"project_key\": \"PRO\",\n" +
                        "  \"description\": \"string\"\n" +
                        "}"))
                .when()
                .post(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
