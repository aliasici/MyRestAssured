package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class HamcrestCollectionSupport {


    @Test
    public void testList(){

        List<Integer> numList = Arrays.asList(4,6,7,9,5,88,90)  ;

        // use hamcrest matcher to test the size of this list
        assertThat(numList , hasSize(7) ) ;

    }


}
