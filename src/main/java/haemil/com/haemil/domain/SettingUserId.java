package haemil.com.haemil.domain;

import java.util.UUID;

public class SettingUserId {
    String userId;

    public static UUID setUserId4(){
        UUID uuid4 = UUID.randomUUID();
        return uuid4;
    }
}
