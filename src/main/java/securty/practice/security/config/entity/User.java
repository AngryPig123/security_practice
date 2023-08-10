package securty.practice.security.config.entity;

import lombok.*;
import securty.practice.security.config.config.Algorithm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Algorithm algorithm;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Authority> authorities = new ArrayList<>();

    @Builder
    public User(String username, String password, Algorithm algorithm) {
        this.username = username;
        this.password = password;
        this.algorithm = algorithm;
    }

}










