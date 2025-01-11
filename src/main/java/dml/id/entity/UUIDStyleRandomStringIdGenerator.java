package dml.id.entity;

import java.util.Random;

public class UUIDStyleRandomStringIdGenerator implements IdGenerator<String> {

    private static char[] characters = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();


    @Override
    public String generateId() {
        Random random = new Random();
        return subRandomString(random, 8)
                + '-' + subRandomString(random, 4)
                + '-' + subRandomString(random, 4)
                + '-' + subRandomString(random, 4)
                + '-' + subRandomString(random, 12);
    }

    private String subRandomString(Random random, int length) {
        StringBuilder sbu = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sbu.append(characters[random.nextInt(characters.length)]);
        }
        return sbu.toString();
    }
}
