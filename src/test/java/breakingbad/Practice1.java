package breakingbad;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;


public class Practice1 {

    @DisplayName("Get all characters")
    @Test
    public void breakingBad(){
        //https://www.breakingbadapi.com/api/characters

        when()
                .get("https://www.breakingbadapi.com/api/characters")
                 .prettyPeek().
        then()

                .statusCode(is(200))
                .header("Content-Type" , is("application/json; charset=utf-8"))

                ;


    }


}
