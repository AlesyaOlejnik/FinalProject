package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    @Test
    public void createProjectTest() { //будет падать тк каждый раз нужны новые данные
        String endPoint = "/api/v1/project";

        given()
                .body(String.format("{\n" +
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
                        "  \"name\": \"Api36\",\n" +
                        "  \"project_key\": \"SAS1\",\n" +
                        "  \"description\": \"sa\"\n" +
                        "}"))
                .when()
                .post(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void createProjectFakerTest() {
        String endPoint = "/api/v1/project";

        Faker faker = new Faker();
        Project project = new Project();
        project.setId(faker.random().nextInt(100));
        project.setName(faker.bothify("####"));
        project.setProjectKey(faker.bothify("####").toUpperCase());
        project.setDescription("#################");

        given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
