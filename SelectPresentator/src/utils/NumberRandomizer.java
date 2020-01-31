package utils;

import java.util.Random;

public class NumberRandomizer implements Randomizer {

    @Override
    public int getRandomNumber(int maxSize) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(maxSize);
    }

}
