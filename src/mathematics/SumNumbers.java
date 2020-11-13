package mathematics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbers {
    /**
     *
     * @param str1 positive number
     * @param str2 positive number
     * @return sum of str1 and str2
     */
    public static String findSumOfTwoNumbers(String str1, String str2)
    {
        /* Before proceeding further, make sure length of str2 is larger.
        If not, swap them
         */
        if (str1.length() > str2.length()){
            String auxiliary = str1;
            str1 = str2;
            str2 = auxiliary;
        }

        // Take an empty String for storing result
        String inversedResult = "";

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both Strings
        for (int i = n1 - 1; i>=0; i--)
        {
            //Do school mathematics, compute sum of current digits and carry
            int sum = ((int)(str1.charAt(i)-'0') +
                    (int)(str2.charAt(i+diff)-'0') + carry);
            inversedResult += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--)
        {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            inversedResult += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            inversedResult += (char)(carry + '0');

        // reverse resultant String
        return new StringBuilder(inversedResult).reverse().toString();
    }

    public static String findSumAllNumbers(String input) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        String result = "";
        while(m.find()) {
            result = findSumOfTwoNumbers(result, m.group());
        }
        return result;
    }
}
