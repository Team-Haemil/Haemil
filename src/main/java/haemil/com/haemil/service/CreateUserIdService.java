package haemil.com.haemil.service;

import haemil.com.haemil.domain.settingUsers;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserIdService {
    settingUsers settingUsers = new settingUsers() {
        public String createUserId() {
            String userId = UUID.randomUUID().toString();

            return userId;
        }
    };
}
