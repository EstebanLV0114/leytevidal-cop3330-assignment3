package ex44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;


public class AppTest
{

    @Test
    @DisplayName("Check if the function JSONCHECKER returns 0 when the product is not in the file")
    public void checkJSONTest1() throws FileNotFoundException
    {

        String directory = System.getProperty("user.dir") + "/src/main/java/ex44/input/ex44_input.json";
        Assertions.assertEquals(0, prodSearch.checkJSON("Watch", directory));

    }

    @Test
    @DisplayName("Check if the function JSONCHECKER returns 1 when the product is in the file")
    public void checkJSONTest2() throws FileNotFoundException
    {

        String directory = System.getProperty("user.dir") + "/src/main/java/ex44/input/ex44_input.json";
        Assertions.assertEquals(1, prodSearch.checkJSON("RandomItem", directory));

    }
}
