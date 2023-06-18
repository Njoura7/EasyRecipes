package njoura.easyRecipes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tags")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "tags")
    private Set<Recipe> recipes = new HashSet<>();
}
