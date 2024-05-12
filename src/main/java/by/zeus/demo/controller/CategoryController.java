package by.zeus.demo.controller;

import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public void getCategory(@PathVariable Long id){
        categoryService.find(id);
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.create(categoryDto);
    }

    @PutMapping ("")
    public void updateCategory(@RequestBody CategoryDto categoryDto){
        categoryService.Update(categoryDto);
    }



    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }
}
