package securty.practice.security.config.security.management;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import securty.practice.security.config.security.CustomUserDetails;
import securty.practice.security.config.entity.User;
import securty.practice.security.config.repository.UserRepository;

import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication");   //  유저 아이디가 없음.

        log.info("loadUserByUsername username = {}", username);

        User user = userRepository
                .findByUsername(username)
                .orElseThrow(s);

        log.info("loadUserByUsername user = {}", user);

        return new CustomUserDetails(user);
    }

}

