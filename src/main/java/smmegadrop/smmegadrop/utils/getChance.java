package smmegadrop.smmegadrop.utils;

import java.util.Random;

public class getChance {
    public static boolean getChance(double chance) {
        Random random = new Random();
        double random1 = random.nextDouble() * 100.0D;
        return random1 <= chance;
    }
}
