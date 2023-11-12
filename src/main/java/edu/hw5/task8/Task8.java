package edu.hw5.task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    //нечетной длины
    public static final Pattern STRING_PATTERN_1 =
        Pattern.compile("^[01]([01]{2})+$");
    //начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static final Pattern STRING_PATTERN_2 =
        Pattern.compile("(^0([01]{2})*$)|(^1[01]([01]{2})*$)");
    //каждый нечетный символ равен 1
    public static final Pattern STRING_PATTERN_3 =
        Pattern.compile("^(1([01]?))*$");

    //нет последовательных 1
    public static final Pattern STRING_PATTERN_4 =
        Pattern.compile("^(?![01]+1{2})[01]*$");

    private Task8() {

    }

    public static boolean isValidString(String str, Pattern stringPattern) {
        boolean result = false;
        if (str != null) {
            Matcher matcher = stringPattern.matcher(str);
            if (matcher.find()) {
                result = true;
            }
        }
        return result;
    }
}
