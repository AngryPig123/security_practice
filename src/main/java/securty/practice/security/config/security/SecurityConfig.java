package securty.practice.security.config.security;


import ch.qos.logback.classic.selector.servlet.LoggerContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import securty.practice.security.config.security.filter.AddLoggerFilter;
import securty.practice.security.config.security.filter.RequestValidateFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .addFilterBefore(   //  필터 체인에서 인증 필터 앞에 맞춤형 필터의 인스턴스를 추가.
                        new RequestValidateFilter(), BasicAuthenticationFilter.class
                )
                .addFilterAfter(
                        new AddLoggerFilter(), BasicAuthenticationFilter.class
                )
                .authorizeRequests()
                .anyRequest()
                .permitAll();

//                .authorizeRequests()
//                .anyRequest()
//                .hasAnyAuthority("WRITE", "READ");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john")
                .password("{noop}12345")
                .roles()
                .authorities("READ")

                .and()
                .withUser("jane")
                .password("{noop}12345")
                .authorities("WRITE");
    }

}
