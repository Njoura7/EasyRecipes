package njoura.easyRecipes.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Tags")
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


}