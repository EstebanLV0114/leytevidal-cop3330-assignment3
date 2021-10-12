package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import java.io.*;
import java.util.*;

public class nameSorter
{

//Main input/output and how the table looks are done here
    public static void main(String[] args)
    {
        List<String> listofnames = new ArrayList<>();

        try
        {
            File input = new File("src/main/java/ex41/input/ex41_input.txt");
            Scanner Input = new Scanner(input);
            while (Input.hasNextLine())
            {
                listofnames.add(Input.nextLine());
            }
            Input.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        int totalNames = listofnames.size();

        String[] lname = spacer(listofnames, 0);
        String[] fname = spacer(listofnames, 1);

        List<String> alphalist = alpha(fname,lname);

        String ofile = "Total of " + totalNames + " names\n-----------------";

        for (int x = 0; x<alphalist.size(); x++)
        {
            ofile = ofile + "\n" + alphalist.get(x);
        }

        File out = new File("src/main/java/ex41/output/ex41_output.txt");
        try
        {
            out.createNewFile();
            FileWriter writeoutput = new FileWriter(out);
            writeoutput.write(ofile);
            writeoutput.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//Changes to the names on the table are done here
    public static List<String> alpha(String[] fname, String[] lname)
    {
        List<String> alphalist;
        int size = lname.length;
        for(int x = 0; x < size-1;x++)
        {
            for(int y = x+1; y<size;y++)
            {
                if(lname[x].compareTo(lname[y])>0)
                {
                    fname = flip(fname, x, y);
                    lname = flip(lname, x, y);
                }

                if(lname[x].compareTo(lname[y])==0)
                {
                    if(fname[x].compareTo(fname[y])>0)
                    {
                        fname=flip(fname,x,y);
                        lname=flip(lname,x,y);
                    }
                }
            }
        }

        alphalist = insert(fname, lname);
        return alphalist;
    }

    public static String[] flip(String[] names, int first, int second)
    {
        String tempvar = names[first];
        names[first] = names[second];
        names[second] = tempvar;
        return names;
    }

    public static List<String> insert(String[] fname, String[] lname)
    {
        List<String> names = new ArrayList<String>();

        for(int x = 0; x < fname.length; x++)
        {
            String tempvar = lname[x] + ", " + fname[x];
            names.add(tempvar);
        }

        return names;
    }

    public static String[] spacer(List<String> names,int x)
    {
        String[] name_spaced = new String[names.size()];

        for(int y = 0; y < names.size(); y++)
        {
            String[] tempvar = names.get(y).split(", ");
            name_spaced[y]=tempvar[x];
        }

        return name_spaced;
    }

}
