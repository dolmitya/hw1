package edu.hw2;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task1 {
    final static int FOUR = 4;

    private Task1() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(FOUR);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        LOGGER.info(res + " = " + res.evaluate());
        cin.close();
    }
}
