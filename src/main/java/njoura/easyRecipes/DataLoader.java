package njoura.easyRecipes;

import njoura.easyRecipes.model.Category;
import njoura.easyRecipes.model.Tag;
import njoura.easyRecipes.repository.CategoryRepository;
import njoura.easyRecipes.repository.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    // CommandLineRunner for categories
    @Bean
    public CommandLineRunner loadCategories(CategoryRepository categoryRepository) {
        return args -> {
            Category breakfast = new Category(1L, "breakfast");
            Category lunch = new Category(2L, "lunch");
            Category dinner = new Category(3L, "dinner");

            categoryRepository.save(breakfast);
            categoryRepository.save(lunch);
            categoryRepository.save(dinner);
        };
    }

    // CommandLineRunner for tags
    @Bean
    public CommandLineRunner loadTags(TagRepository tagRepository) {
        return args -> {
            Tag spicy = new Tag(null, "spicy");
            Tag sweet = new Tag(null, "sweet");
            Tag salty = new Tag(null, "salty");
            Tag french = new Tag(null, "french");
            Tag hungarian = new Tag(null, "hungarian");
            Tag italian = new Tag(null, "italian");
            Tag asian = new Tag(null, "asian");
            Tag fastFood = new Tag(null, "fast food");

            tagRepository.save(spicy);
            tagRepository.save(sweet);
            tagRepository.save(salty);
            tagRepository.save(french);
            tagRepository.save(hungarian);
            tagRepository.save(italian);
            tagRepository.save(asian);
            tagRepository.save(fastFood);
        };
    }
}
