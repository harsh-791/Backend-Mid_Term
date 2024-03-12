package dev.harsh.midterm.Services;

import dev.harsh.midterm.DTO.FakeStoreDto;
import dev.harsh.midterm.Models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class CategoryService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";
    public FakeStoreDto[] getbyCategory(@PathVariable String category_name){
        FakeStoreDto[] response = restTemplate.getForObject(url+"/products/category/"+category_name, FakeStoreDto[].class);
        return response;
    }



}
