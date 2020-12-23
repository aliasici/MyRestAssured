package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;

public class HamcrestMatchersTest {
    /*
        Static imports
    In order to use REST assured effectively it's recommended
    to statically import methods from the following classes:

    import static io.restassured.RestAssured.* ;
    import static io.restassured.matcher.RestAssuredMatchers.* ;
    import static org.hamcrest.Matchers.* ;
     */

    //Hamcrest assertion library already part of our RestAssured in pom file
    //N0 separate dependency needed
    @DisplayName("Test 1 + 3 = 4")
    @Test
    public void test1(){
        assertThat(1+3,is(4));


    }
}
