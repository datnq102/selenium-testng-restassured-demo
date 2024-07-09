package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApiTests {
    private String token;
    private String email = "eve.holt@reqres.in", password = "cityslicka";

    @BeforeClass
    @Parameters({"baseURI"})
    public void setUp(String baseURI){
        RestAssured.baseURI = baseURI;
        token = getToken(email, password);
    }

    public String getToken(String email, String password){
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .post("/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        return response.jsonPath().getString("token");
    }

    @Test
    public void testLoginSuccessful(){
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .post("/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));
    }

    @Test
    public void testLoginUnsuccessfulWithInvalidEmail(){
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"email\": \"invalidEmail\", \"password\": \"" + password + "\" }")
                .post("/login");

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNotNull(response.jsonPath().getString("error"));
    }

    @Test
    public void testLoginUnsuccessfulMissingEmail(){
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"email\": \"\", \"password\": \"" + password + "\" }")
                .post("/login");

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNotNull(response.jsonPath().getString("error"));
    }

    @Test
    public void testGetUserSuccessful(){
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("data"));
    }

    @Test
    public void testGetUserNotFound(){
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/users/9999");

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testGetUserInvalidUserId(){
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .get("/users/invalid-userId");

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void testUpdateUserSuccessful(){
        String newName = "new name", newJob = "new job";
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"name\": \"" + newName + "\", \"job\": \"" + newJob + "\" }")
                .put("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), newName);
        Assert.assertEquals(response.jsonPath().getString("job"), newJob);
    }

    @Test
    public void testUpdateUserSuccessfulWithNameOnly(){
        String newName = "new name only";
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"name\": \"" + newName + "\"}")
                .put("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), newName);
    }

    @Test
    public void testUpdateUserSuccessfulWithNewJobOnly() {
        String newJob = "new job only";
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"job\": \"" + newJob + "\" }")
                .put("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("job"), newJob);
    }

    @Test
    public void e2eTest() {
        testLoginSuccessful();
        testGetUserSuccessful();
        testUpdateUserSuccessful();
    }
}
