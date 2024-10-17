package service;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
    }

    public Category save(Category category) {
/*        List<Category> categories = categoryRepository.findAll();
        if (categories.stream()
                .anyMatch(c -> c.getName().equals(category.getName()))) {
            throw new IllegalArgumentException("Category name already exists!");
        }*/
        return categoryRepository.save(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


}
