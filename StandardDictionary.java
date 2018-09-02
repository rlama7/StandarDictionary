/**
 * Main.java    --A driver program to implement a Standard dictionary using a HashMap.
 * @author		  Ratna Lama
 * @version   	  1.0
 * @since     	  6/12/2018
 */

import java.util.Scanner;
import java.util.HashMap;

public class StandardDictionary {

    /**
     * Algorithm:
     * Asks user to search for a key.
     * Checks if the search key is in the ENUM list.
     * If the search key is found then displays its values,
     * if the search key is not found then displays not found message.
     * The program terminates when user enters "!q" or "!Q"
     *
     * @parm 	args 	the command-line argument
     */

    public static void main(String[] args) {
        boolean flag = true;
        Scanner reader = new Scanner(System.in);

        HashMap<String, CSCEntries> stdDictionary = new HashMap<>();

        // Enters items to the Standard Dictionary
        for (CSCEntries entry : CSCEntries.values()) {
            stdDictionary.put(entry.name(), entry);
        }

        System.out.println("\n-------------DICTIONARY 340 Standard-------------------\n");

        while(flag) {
            System.out.print("Search: ");
            String input = reader.nextLine().toUpperCase();

            CSCEntries search = stdDictionary.get(input);

            if (input.equalsIgnoreCase("!Q")) {     // Exit if input is "!q" or "!Q"
                flag = false;

            } else if(search != null){

                System.out.print("\t|\n");

                if (!search.getDefinition().isEmpty()) {

                    System.out.print("\t " + search.getDefinition().substring(0,1) +search.getDefinition().substring(1).toLowerCase() + " : " + search.getDescription() + "\n");

                    if(!search.getNoun().isEmpty()) {
                        System.out.print("\t " + search.getNoun() + "\n");
                    }

                } else {
                    if (!search.getDescription().isEmpty()) {

                        System.out.print("\t " + input + " : " + search.getDescription() + "\n");
                    }

                    if (!search.getNoun().isEmpty()) {
                        System.out.print("\t " + input + " : " + search.getNoun() + "\n");
                    }

                    if (!search.getVerb().isEmpty()) {
                        System.out.print("\t " + input + " : " + search.getVerb() + "\n");
                    }

                    if (!search.getAdjective().isEmpty()) {
                        System.out.print("\t " + input + " : " + search.getAdjective() + "\n");
                    }

                }

                System.out.println("\t|\n");

            } else {
                System.out.println("\t|\n" + "\t <Not found>\n" + "\t|\n");

            } // end if -else-if -else

        } // end while loop

        System.out.println("\n------------THANK YOU--------------\n");

    } // end main method

} // end StandardDictionary Class
