package securty.practice.security.config.entity;

import lombok.*;

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
    private String currency;

    @Builder
    public Product(String name, String price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

}
