package ex44;

import java.io.*;
import java.util.*;
import com.google.gson.*;

public class prodSearch
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        String directory = System.getProperty("user.dir") + "/src/main/java/ex44/input/ex44_input.JSON";
        System.out.print("What is the product name? ");
        String element = scan.nextLine();

        while(checkJSON(element,directory) == 0)
        {
            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.print("What is the product name? ");
            element = scan.nextLine();
        }

    }

    public static int checkJSON(String element, String newDir)
    {
        int check = 0;
        int i = 0;
        Gson gson = new Gson();

        try(Reader readerTool = new FileReader(newDir))
        {
            JsonElement jelement = gson.fromJson(readerTool, JsonElement.class);
            JsonObject Name = jelement.getAsJsonObject();
            JsonArray array = Name.get("products").getAsJsonArray();

            while (i < array.size())
            {
                String names = array.get(i).getAsJsonObject().get("name").getAsString();

                if (names.equals(element))
                {

                    System.out.println("Name: " + array.get(i).getAsJsonObject().get("name").getAsString());
                    System.out.println("Price: " + array.get(i).getAsJsonObject().get("price").getAsString());
                    System.out.print("Quantity: " + array.get(i).getAsJsonObject().get("quantity").getAsString());
                    check = 1;
                }
                i++;
            }

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        return check;
    }


}
