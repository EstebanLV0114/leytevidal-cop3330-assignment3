package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Esteban Leyte-Vidal
 */

import java.io.*;
import java.util.*;

public class webGen
{

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        do
        {
            genSite();
        } while (true);
    }

    public static String userInput(String prompt)
    {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static String genSite()
    {
        String name = userInput("Site name: ");
        String auth = userInput("Author: ");
        boolean js_Folder = userInput("Do you want a folder for JavaScript? ").equalsIgnoreCase("y");
        boolean css_Folder = userInput("Do you want a folder for CSS? ").equalsIgnoreCase("y");

        String site = genSite(name, auth, js_Folder, css_Folder);
        return site;
    }

    public static String genSite(String name, String auth, boolean js, boolean css)
    {
        String parent = "website";
        String child = parent + "/" + name;

        directory(parent);
        directory(child);

        String content = String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>%s</title>\n" +
                "    <meta name=\"author\" content=\"%s\">\n" +
                "  </head>\n" +
                "  \n" +
                "  <body>\n" +
                "  </body>\n" +
                "</html>", name, auth);
        html(content, child + "/index.html");

        if (js)
        {
            directory(child + "src/main/java/ex43/website/js");
        }
        if (css)
        {
            directory(child + "src/main/java/ex43/website/css");
        }

        return content;
    }

    public static boolean directory(String name)
    {
        File dir = new File(name);
        try
        {
            System.out.println("Created " + dir.getCanonicalPath());
        }
        catch (Exception e)
        {

        }
        return dir.mkdir();
    }

    public static void html(String content, String fname)
    {
        try
        {
            File file = new File(fname);
            PrintWriter write = new PrintWriter(file);
            write.println(content);
            write.flush();
            write.close();

            System.out.println("Created " + file.getCanonicalPath());
        }
        catch (Exception e)
        {
            System.out.println("Could not create html file!");
        }

    }

}
