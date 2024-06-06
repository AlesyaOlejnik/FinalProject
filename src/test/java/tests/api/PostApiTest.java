package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    @Test
    public void createProjectTest() {
        String endPoint = "/api/v1/project";

        String body = "{\n" +
                "  \"id\": 10,\n" +
                "  \"is_deleted\": true,\n" +
                "  \"created_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                "  \"created_by\": 0,\n" +
                "  \"modified_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                "  \"modified_by\": 0,\n" +
                "  \"deleted_at\": \"1970-01-01T00:00:00.000Z\",\n" +
                "  \"deleted_by\": 0,\n" +
                "  \"_etag\": \"string\",\n" +
                "  \"owner_user_id\": 0,\n" +
                "  \"name\": \"%s\",\n" +
                "  \"project_key\": \"%s\",\n" +
                "  \"description\": \"sa\"\n" +
                "}";

        String projectKey = UUID.randomUUID().toString().toUpperCase().substring(0, 4);
        UUID projectName = UUID.randomUUID();

        given()
                .body(String.format(body, projectName, projectKey))
                .when()
                .post(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
