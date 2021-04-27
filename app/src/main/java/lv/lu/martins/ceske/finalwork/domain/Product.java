package lv.lu.martins.ceske.finalwork.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "PRODUCTS")
@Entity(name = "PRODUCTS")
@Data
@EqualsAndHashCode
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "category", nullable = false)
    private ProductCategory category;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "description")
    private String description;

}
