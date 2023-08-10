package securty.practice.security.config.config;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Algorithm {
    BCRYPT("BCRYPT"),
    SCRYPT("SCRYPT");

    private final String name;

    public String getAlgorithm() {
        return name;
    }

}
