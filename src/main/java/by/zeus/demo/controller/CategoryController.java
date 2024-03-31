package by.zeus.demo.controller;

import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public void getCategory(@RequestParam Long Id){
        categoryService.find(Id);
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.create(categoryDto);
    }
}
