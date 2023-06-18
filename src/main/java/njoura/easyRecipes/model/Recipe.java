package njoura.easyRecipes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Recipes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;


    }
