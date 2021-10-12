package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import java.io.*;
import java.util.*;

public class wordFind
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String fname = input.nextLine();
        input.close();
        String inputString;
        String outputstring = "";

        File inputFile = new File("src/main/java/ex45/input/ex45_input.txt");
        File outputFile = new File("src/main/java/ex45/output/"+ fname +".txt");

        try
        {
            input = new Scanner(inputFile);
            int x =0;
            while(x==0)
            {
                if(input.hasNextLine())
                {
                    inputString = input.nextLine();
                    int y=0;
                    while(y==0)
                    {
                        int z;
                        if(inputString.contains("utilize"))
                        {
                            z = inputString.indexOf("utilize");
                            inputString = inputString.substring(0,z) +"use"+ inputString.substring(z+7);
                        }
                        else if(inputString.contains("Utilize"))
                        {
                            z = inputString.indexOf("Utilize");
                            inputString = inputString.substring(0,z) +"use"+ inputString.substring(z+7);
                        }
                        else
                        {
                            y++;
                        }
                    }
                    outputstring += inputString+"\n";
                }
                else
                {
                    x=1;
                }
            }

            outputFile.createNewFile();
            FileWriter write = new FileWriter(outputFile);
            write.write(outputstring);
            write.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
