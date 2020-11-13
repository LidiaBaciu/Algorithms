package mathematics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equation {
    /**
     * @param str equation string
     * @param regex regex rule
     * @return the sum of all the coefficients of the same type
     * e.g.: 2x^2 + 2x -3x -25 +15 =0, for the coeff of x^0 will return -10
     */
    public static double coeff(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        // missing coefficient default
        String coeff = "+0";
        double value = 0;
        while(match.find()){
            coeff = match.group(1);
            value = value + Double.parseDouble(coeff);
        }
        // always have sign, handle implicit 1
        return (coeff.length() == 1) ? (value + 1) : value;
    }

    /**
     * Solve the equation
     * @param arg equation to be solved
     * @return the solutions of the equation
     */
    public static String[] quadParse(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");

        double a1 = coeff(str, "([+-][0-9]*)x\\^2");
        double b1 = coeff(str, "([+-][0-9]*)x(?!\\^)");
        double c1= coeff(str, "([+-][0-9]+)(?!x)");
        System.out.println("Values are a: " + a1 + " b: " + b1 + " c: " + c1);
        double delta = (Math.pow(b1, 2.0)) - (4 * a1 * c1);
        double sqrtDelta = Math.sqrt(delta);
        double x1, x2; //root 1 & root 2, respectively

        if (delta > 0.0 || delta < 0.0) {
            x1 = (-b1 + sqrtDelta) / (2.0 * a1);
            x2 = (-b1 - sqrtDelta) / (2.0 * a1);
            String root1 = Double.toString(x1);
            String root2 = Double.toString(x2);
            return new String[]{root1, root2};
        } else if (delta == 0.0) {
            x1 = (-b1 + 0.0) / (2.0 * a1);//repeated root
            String root2 = Double.toString(x1);
            return new String[]{root2};
        }
        return new String[-1];
    }
}
