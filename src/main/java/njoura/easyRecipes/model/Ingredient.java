package njoura.easyRecipes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Ingredients")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity;

}