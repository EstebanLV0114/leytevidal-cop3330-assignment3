package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class AppTest
{

    List<String> names = Arrays.asList("Ling, Mai", "Johnson, Jim","Zarnecki, Sabrina","Jones, Chris","Jones, Aaron","Swift, Geoffrey","Xiong, Fong");

    @Test
    void spacer()
    {
        String[] lastNameExp = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        assertArrayEquals(lastNameExp, ex42.parsingData.spacer(names, 0));
        String[] firstNameExp = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        assertArrayEquals(firstNameExp, ex42.parsingData.spacer(names, 1));

    }

}
