package services.loginservices;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class PasswordEncoder {
    private final Logger logger;

    PasswordEncoder() {
        logger = Logger.getLogger(PasswordEncoder.class);
    }

    private String md5(String password) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = password.getBytes();
            byte[] arraySecond = md.digest(array);
            result = new String(arraySecond);
        } catch (NoSuchAlgorithmException e) {
            logger.error("This is Error : " + e.getMessage());
        }
        return result;
    }

    String encode(String password) {
        String result = md5(password) + "salt";
        StringBuilder stringBuilder = new StringBuilder(result).reverse();
        result = stringBuilder.toString();
        result = md5(result);
        return result;
    }

}
