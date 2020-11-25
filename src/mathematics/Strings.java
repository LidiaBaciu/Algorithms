package mathematics;

import java.util.Scanner;

public class Strings {

    public static void countUpperCaseCharacters (){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter tNumber:");
        int tNumber = in.nextInt();
        in.nextLine();
        for(int currentLine = 0; currentLine < tNumber; currentLine++){
            System.out.println("Enter the string:");
            String currentInput = in.nextLine();
            int counter = countUpperCaseCharacters(currentInput);
            System.out.println(counter);
        }
    }

    private static int countUpperCaseCharacters(String input){
        int count = 0;
        char chars[] = input.toCharArray();
        for (Character character:chars) {
            if(character >= 65 && character <= 90) {
                count++;
            }
        }
        return count;
    }

    public static String recursiveReverseString(String input){
        //check it there is only one character left
        if(input.length() == 1){
            return input;
        } else {
            /*return the concatenation of the last character
            and call the function again but remove the character already added
             */
            return input.charAt(input.length()-1)
                    + recursiveReverseString(input.substring(0, input.length()-1));
        }
    }

    public static String iterativeReverseString(String input){
        String result = "";
        for(int currentPosition = input.length()-1; currentPosition >= 0; currentPosition--){
            result = result + input.charAt(currentPosition);
        }
        return result;
    }
}
