package level.up.kaabar.model;

import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drink_id_seq")
    @SequenceGenerator(name = "drink_id_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String name;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String brand;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private int price;

    @Setter
    @Column(nullable = false, updatable = true, length = 50)
    private int quantity;

    @Column(nullable = false, updatable = false, length = 50)
    @NotBlank
    private String typ;
/*
    @Setter
    @Column
    //@ManyToOne
    private int managerId;
*/
    /*
    @ManyToOne
    @Getter
    @Setter
    private User user;


*/
    public Drink(String name, String brand, int price, int quantity, String typ) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.typ = typ;
    }

    public Drink() {

    }

}
