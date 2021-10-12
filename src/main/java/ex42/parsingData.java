package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import java.util.*;
import java.io.*;

public class parsingData
{
    public static void main (String [] args)
    {
        List<String> fileinput = new ArrayList<>();
        try
        {
            File location = new File("src/main/java/ex42/input/ex42_input.txt");
            Scanner input = new Scanner(location);
            while (input.hasNextLine())
            {
                fileinput.add(input.nextLine());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String[] lname = spacer(fileinput,0);
        String[] fname = spacer(fileinput, 1);
        String[] money = spacer(fileinput,2);
        System.out.printf("%-10s %-10s %-10s%n-------------------------------%n","Last","First","Salary");

        for(int x=0; x < lname.length;x++)
        {
            System.out.printf("%-10s %-10s %-10s%n",lname[x], fname[x], money[x]);
        }
    }

    public static String[] spacer(List<String> names,int x)
    {
        String[] insert = new String[names.size()];

        for(int y = 0; y < names.size(); y++)
        {
            String[] tempvar = names.get(y).split(",");
            insert[y] = tempvar[x];
        }
        return insert;
    }

}
