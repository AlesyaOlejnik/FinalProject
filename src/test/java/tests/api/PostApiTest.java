package tests.api;

import baseEntities.BaseApiTest;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    @Test
    @SneakyThrows
    public void createProjectTest() {
        String endPoint = "/api/v1/project";

        String projectKey = UUID.randomUUID().toString().toUpperCase().substring(0, 4);
        UUID projectName = UUID.randomUUID();

        String body = FileUtils.readFileToString(new File("src/test/resources/post.json"), StandardCharsets.UTF_8);
        given()
                .body(String.format(body, projectName, projectKey))
                .when()
                .post(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
