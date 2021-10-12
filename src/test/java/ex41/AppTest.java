package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


class AppTest
{
    List<String> names = Arrays.asList("Ling, Mai", "Johnson, Jim","Zarnecki, Sabrina","Jones, Chris","Jones, Aaron","Swift, Geoffrey","Xiong, Fong");

    @Test
    void spacer()
    {
        String[] lastNameExp = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};

        assertArrayEquals(lastNameExp,nameSorter.spacer(names, 0));

        String[] firstNameExp = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};

        assertArrayEquals(firstNameExp, nameSorter.spacer(names, 1));
    }

    @Test
    void alpha()
    {
        String[] first_name = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        List<String> alpha = new ArrayList<>(Arrays.asList("Johnson, Jim","Jones, Aaron","Jones, Chris","Ling, Mai", "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina"));

        assertArrayEquals(alpha.toArray(), nameSorter.alpha(first_name,last_name).toArray());
    }

    @Test
    void flip()
    {
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};
        String[] last_name_flip12 = {"Johnson","Ling","Zarnecki","Jones","Jones","Swift","Xiong"};

        assertArrayEquals(last_name_flip12, nameSorter.flip(last_name,0,1));
    }

    @Test
    void fill()
    {
        String[] first_name = {"Mai", "Jim", "Sabrina","Chris", "Aaron", "Geoffrey", "Fong"};
        String[] last_name = {"Ling","Johnson","Zarnecki","Jones","Jones","Swift","Xiong"};

        assertArrayEquals(names.toArray(),nameSorter.insert(first_name,last_name).toArray());
    }
}
