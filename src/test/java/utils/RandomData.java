package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {
    // Random String
    public static String getRandomString(int length) {
        String randomSequence = "ABCDEFGHIGabcdefghig";
        StringBuilder result = new StringBuilder(randomSequence);
        Random rnd = new Random();
        while (result.length() <= length) {
            int index = (int) (rnd.nextFloat() * randomSequence.length());
            result.append(randomSequence.charAt(index));
        }
        return result.toString();

    }
    // Random Alphabetic string

    public static String getAlphabeticRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    // Random long

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
}
