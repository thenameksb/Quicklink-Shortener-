package linkshortener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShortKeyGenerator {

    private final MessageDigest md;

    public ShortKeyGenerator() {
        try {
            this.md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error initializing hash function.", e);
        }
    }

    public String generateShortKey(String originalUrl) {
        byte[] digest = md.digest(originalUrl.getBytes());
        StringBuilder shortKey = new StringBuilder();
        for (byte b : digest) {
            shortKey.append(String.format("%02x", b));
        }
        return shortKey.toString().substring(0, 8);
    }
}
