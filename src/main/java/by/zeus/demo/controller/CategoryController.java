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

    @GetMapping("")
    public void getCategory(@RequestParam Long Id){
        categoryService.find(Id);
    }

    @PostMapping("")
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
