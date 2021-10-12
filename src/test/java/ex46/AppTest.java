package ex46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppTest
{

    @Test
    public void count() throws IOException
    {
        Map<String, Integer> testMap = new HashMap<>();

        testMap.put("snake", 1);
        testMap.put("mushroom", 2);
        testMap.put("badger", 7);

        Map<String, Integer> mytMap;
        ArrayList<String> inputList = new ArrayList<>();
        String directory = System.getProperty("user.dir") + "/src/main/java/ex46/input/ex46_input.txt";
        String current;
        FileReader file = new FileReader(directory);
        BufferedReader scan = new BufferedReader(file);

        while ((current = scan.readLine()) != null)
        {
            inputList.add(current);
        }

        mytMap = wordFreq.count(inputList);

        Assertions.assertEquals(testMap, mytMap);

    }
}