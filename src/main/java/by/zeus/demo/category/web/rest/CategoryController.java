package by.zeus.demo.controller;

import by.zeus.demo.Mapper.CategoryMapper;
import by.zeus.demo.dto.CategoryDetailsDto;
import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.CategoryDetails;
import by.zeus.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Long id){
       return CategoryMapper.toDto(categoryService.findOne(id).get());
    }

    @GetMapping("/details/{id}")
    public List<CategoryDetailsDto> getDetails(@PathVariable Long id){
       return categoryService.getCategoryDetails(id);
    }

    @GetMapping("")
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> result = new ArrayList<CategoryDto>();
        for(Category category : categoryService.findAll()){
            result.add(CategoryMapper.toDto(category));
        }
        return result;
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

    @DeleteMapping("")
    public void deleteCategory(){
        categoryService.deleteAll();
    }
}
