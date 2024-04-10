package utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUtil {
    public static String encrypt(String raw)
    {
        return BCrypt.hashpw(raw, BCrypt.gensalt());
    }

    public static boolean verify(String raw, String hashed)
    {
        return BCrypt.checkpw(raw, hashed);
    }
}
