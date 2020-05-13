package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashGenerator implements BasicHashGenerator {

    MessageDigest digest;

    public HashGenerator() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getHash(String input) {

        /* Applies sha256 to our input */
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();

        for (byte elem: hash) {
            String hex = Integer.toHexString(0xff & elem);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
