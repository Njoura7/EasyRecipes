package njoura.easyRecipes.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Recipes")
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

    private String ingredient;

    // Define the relationship between Recipe and Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Define the relationship between Recipe and Tag
    @ManyToMany
    @JoinTable(
            name = "recipe_tags",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    // Add categoryName as a derived property using @Formula
    @Formula("(SELECT c.name FROM Categories c WHERE c.id = category_id)")
    private String categoryName;

    // Add tagTitles as a derived property using @Formula
    @Formula("(SELECT GROUP_CONCAT(t.title) FROM Tags t JOIN recipe_tags rt ON t.id = rt.tag_id WHERE rt.recipe_id = id)")
    private String tagTitles;
}
