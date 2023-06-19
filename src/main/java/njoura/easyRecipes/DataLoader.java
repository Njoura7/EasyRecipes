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
            Category breakfast = new Category("breakfast");
            Category lunch = new Category("lunch");
            Category dinner = new Category("dinner");

            categoryRepository.save(breakfast);
            categoryRepository.save(lunch);
            categoryRepository.save(dinner);
        };
    }

    // CommandLineRunner for tags
    @Bean
    public CommandLineRunner loadTags(TagRepository tagRepository) {
        return args -> {
            Tag spicy = new Tag("spicy");
            Tag sweet = new Tag("sweet");
            Tag salty = new Tag("salty");
            Tag french = new Tag("french");
            Tag hungarian = new Tag("hungarian");
            Tag italian = new Tag("italian");
            Tag asian = new Tag("asian");
            Tag fastFood = new Tag("fast food");

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

