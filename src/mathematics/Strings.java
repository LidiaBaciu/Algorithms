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
}
