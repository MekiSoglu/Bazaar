package by.zeus.demo.category.web.rest;

import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.service.CategoryDetailsService;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.web.mapper.CategoryDetailsMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catDetails")
@CrossOrigin ( {"http://localhost:4401", "http://localhost:4200"} )

public class CategoryDetailsController {

    private final CategoryDetailsService categoryDetailsService;

    public CategoryDetailsController(CategoryDetailsService categoryDetailsService) {
        this.categoryDetailsService = categoryDetailsService;
    }

    @GetMapping("/{Id}")
    public CategoryDetails find(@PathVariable Long Id){
        return categoryDetailsService.findOne(Id).get();
    }

    @GetMapping("")
    public List<CategoryDetails> findAll(){
        return categoryDetailsService.findAll();
    }

    @GetMapping("/dto")
    public List<CategoryDetailsDto> findAllDto(){
        List<CategoryDetails> details=categoryDetailsService.findAll();
        List<CategoryDetailsDto> dtos=new ArrayList<>();
        for(CategoryDetails detail:details){
            dtos.add(CategoryDetailsMapper.toDto(detail));
        }
        return dtos;
    }

    @PostMapping("")
    public void create(@RequestBody  CategoryDetailsDto categoryDetailsDto){
        categoryDetailsService.create(categoryDetailsDto);
    }

    @PutMapping("")
    public void update(@RequestBody CategoryDetailsDto categoryDetailsDto){
        categoryDetailsService.Update(categoryDetailsDto);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable Long Id){
        categoryDetailsService.delete(Id);
    }

    @DeleteMapping("")
    public void deleteAll(){
        categoryDetailsService.deleteAll();
    }

}
