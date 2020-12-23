package day01;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AssertingCollectionInTheChain {

    /*
     extract() method of RestAssured
     enable you to extract data after validation
     in then section of the method chaining
     */
    @BeforeAll
    public static void setUp(){
        baseURI = "http://18.234.80.193:8000";
        basePath = "/api" ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("Testing GET /api/spartans/search with Basic auth")
    @Test
    public void testSearchAndExtractData(){

        JsonPath jp = given()
                            .auth().basic("admin","admin")
                            .queryParam("nameContains","a")
                            .queryParam("gender","Female").
                    when()
                            .get("/spartans/search").
                    then()
                            .assertThat()
                            .statusCode(is(200))
                        .extract()
                            .jsonPath();
        // get the list of all names in String
        List<String> allNames =  jp.getList("content.name");
        System.out.println("allNames = " + allNames);

//         we are getting numberOfElements field from json result
//         since it's a top level key , json path will be just numberOfElements
        int numOfElements = jp.getInt("numberOfElements");
        System.out.println("numOfElements = " + numOfElements);
        // verifying the numOfElements match the size of list we got
        assertThat(numOfElements , equalTo( allNames.size() )    );





    }




}
