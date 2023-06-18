package njoura.easyRecipes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Categories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // Ensure uniqueness of category names
    private String name;

    // Use a static initializer block to set the predefined category names
    static {
        Category breakfast = new Category();
        breakfast.setName("breakfast");

        Category lunch = new Category();
        lunch.setName("lunch");

        Category dinner = new Category();
        dinner.setName("dinner");
    }


}