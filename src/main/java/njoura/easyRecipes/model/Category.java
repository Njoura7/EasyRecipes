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

    private String name;


}