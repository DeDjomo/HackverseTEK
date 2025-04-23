package cm.polytechnique.Mail;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OTPService {

    private static class OTPInfo {
        String code;
        LocalDateTime createdAt;

        OTPInfo(String code, LocalDateTime createdAt) {
            this.code = code;
            this.createdAt = createdAt;
        }
    }

    private static final Map<String, OTPInfo> otpStorage = new HashMap<>();
    private final int EXPIRATION_MINUTES = 5;

    // Générer et enregistrer un code
    public static String genererCode(String email) {
        String code = String.format("%06d", new Random().nextInt(999999));
        otpStorage.put(email, new OTPInfo(code, LocalDateTime.now()));
        return code;
    }

}

