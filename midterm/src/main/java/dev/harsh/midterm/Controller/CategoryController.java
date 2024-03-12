package dev.harsh.midterm.Controller;

import dev.harsh.midterm.DTO.FakeStoreDto;
import dev.harsh.midterm.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    CategoryService cs;
    CategoryController(CategoryService cs){
        this.cs = cs;
    }

    @GetMapping("/product/category/{category_name}")
    public FakeStoreDto[] getbyCategory(@PathVariable String category_name){
        return cs.getbyCategory(category_name);
    }


}
