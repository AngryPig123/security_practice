package securty.practice.security.config.security.management.password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class PasswordEncoderManager {

    @Bean("bcryptPasswordEncoderBean")
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("scryptPasswordEncoderBean")
    public SCryptPasswordEncoder scryptPasswordEncoder() {
        return new SCryptPasswordEncoder();
    }

}
