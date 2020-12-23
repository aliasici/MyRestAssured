package day01;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;
public class RestAssuredIntro {

    @DisplayName("Spartan/api/hello Endpoint Test")
    @Test
    public void TestHello(){
        // http://18.234.80.193:8000/api/hello
        // I have used my own IP

      Response response = get("http://18.234.80.193:8000/api/hello");
      // get status code out of this Response object

        System.out.println("response.statusCode() is = " + response.statusCode());

        // assert the status code is 200

        assertThat(response.statusCode(), is(200));

        //how to pretty print entire response body~payload
        //prettyPrint() -- print and return payload as String

        String payload = response.prettyPrint();

        assertThat(payload, is("Hello from Sparta"));

        // get the header called ContentType from the response
        System.out.println( response.getHeader("Content-Type"));


    }
}
