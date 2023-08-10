package securty.practice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import securty.practice.security.config.entity.Authority;
import securty.practice.security.config.entity.User;
import securty.practice.security.config.repository.AuthorityRepository;
import securty.practice.security.config.repository.ProductRepository;
import securty.practice.security.config.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

import static securty.practice.security.config.config.enumerated.Algorithm.BCRYPT;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityApplication {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AuthorityRepository authorityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @PostConstruct
    public void init() {

        User user = User.builder()
                .username("john")
                .password(bCryptPasswordEncoder.encode("12345"))
                .algorithm(BCRYPT)
                .build();

        userRepository.save(user);

        List<Authority> authorities = List.of(
                Authority.builder()
                        .name("create")
                        .user(user)
                        .build(),
                Authority.builder()
                        .name("read")
                        .user(user)
                        .build(),
                Authority.builder()
                        .name("update")
                        .user(user)
                        .build(),
                Authority.builder()
                        .name("delete")
                        .user(user)
                        .build()
        );

        authorityRepository.saveAll(authorities);

    }


}
