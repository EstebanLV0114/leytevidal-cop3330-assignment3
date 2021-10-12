package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import java.io.*;
import java.util.*;

public class wordFreq
{

    public static void main(String[] args)
    {

        String input = System.getProperty("user.dir") + "/src/main/java/ex46/input/ex46_input.txt";
        String current;
        ArrayList<String> inputList = new ArrayList<>();

        try
        {
            FileReader read = new FileReader(input);
            BufferedReader scan = new BufferedReader(read);

            while ((current = scan.readLine()) != null)
            {
                inputList.add(current);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (inputList.isEmpty())
        {
            System.out.println("Error! Try Again...");
            System.exit(-1);
        }

        Map<String, Integer> iMap;
        iMap = count(inputList);

        List<String> word = new ArrayList<>(iMap.keySet());
        List<Integer> freq = new ArrayList<>(iMap.values());

        Collections.sort(word);
        Collections.sort(freq);

        int length = word.size()-1;

        for (int i = length; i >= 0 ; i--)
        {
            System.out.print(word.get(length-i)+":");

            for(int j = 0; j <freq.get(i); j++)

                System.out.print("*");

            System.out.print("\n");
        }

    }

    public static Map<String, Integer> count(ArrayList<String> list_input)
    {
        int i = 0;
        Map<String, Integer> iMap = new HashMap<>();
        Set<String> temp = new HashSet<>();

        while (i < list_input.size())
        {
            String[] check = (list_input.get(i)).split(" ");
            for(int j = 0; j<check.length; j++)
            {
                temp.add(check[j]);
            }

            i++;
        }

        for (String counter: temp)
        {
            iMap.put(counter,0);
        }

        i = 0;

        while (i < list_input.size())
        {
            String[] tempvar = (list_input.get(i)).split(" ");
            for(int j = 0; j < tempvar.length; j++)
                if (!temp.add(tempvar[j]))
                {
                    for (Map.Entry<String, Integer> current : iMap.entrySet())
                    {
                        if (current.getKey().equals(tempvar[j]))
                        {
                            current.setValue(current.getValue() + 1);
                        }
                    }
                }
            i++;
        }
        return iMap;
    }
}