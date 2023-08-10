package securty.practice.security.config.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean("bCryptPasswordEncoderBean")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean("sCryptPasswordEncoderBean")
//    public SCryptPasswordEncoder sCryptPasswordEncoder() {
//        return new SCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests(authority ->

                        authority
                                .antMatchers("/").permitAll()
                                .antMatchers("/").permitAll()
                                .antMatchers("/").permitAll()
                                .antMatchers("/").permitAll()
                );

        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();

    }

}
