package securty.practice.security.config.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import securty.practice.security.config.security.enumerated.Currency;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Product(String name, String price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

}
