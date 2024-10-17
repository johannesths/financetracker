package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        if (category == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(categoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        if (category == null || (!Objects.equals(id, category.getCategory_id())))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        if (categoryService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
