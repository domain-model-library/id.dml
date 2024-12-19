package dml.id.entity;

import java.util.Random;

public class UUIDStyleRandomStringIdGenerator implements IdGenerator<String> {

    private static char[] characters = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();


    @Override
    public String generateId() {
        return subRandomString(8)
                + '-' + subRandomString(4)
                + '-' + subRandomString(4)
                + '-' + subRandomString(4)
                + '-' + subRandomString(12);
    }

    private String subRandomString(int length) {
        Random random = new Random();
        StringBuilder sbu = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sbu.append(characters[random.nextInt(characters.length)]);
        }
        return sbu.toString();
    }
}
