package smmegadrop.smmegadrop.utils;

import java.util.Random;

public class randomizeAmount {
    public static int randomAmount(int max) {
        Random rand = new Random();
        int number = rand.nextInt(max) + 1;
        return number;
    }
}
