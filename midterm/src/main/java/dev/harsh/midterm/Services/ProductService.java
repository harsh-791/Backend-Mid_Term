package dev.harsh.midterm.Services;

import dev.harsh.midterm.DTO.FakeStoreDto;
import dev.harsh.midterm.Models.Category;
import dev.harsh.midterm.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";
    public FakeStoreDto[] getAllProducts(){
        FakeStoreDto[] response = restTemplate.getForObject(url+"/products", FakeStoreDto[].class);
        return response;
    }

    public FakeStoreDto getProductById(@PathVariable Long id){
        FakeStoreDto response = restTemplate.getForObject(url+"/products/"+id, FakeStoreDto.class);
        return response;
    }

    public Product createProduct( Product product){
        FakeStoreDto fakeStoreProduct = new FakeStoreDto();
        fakeStoreProduct.setTitle(product.getTitle());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageURL());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        FakeStoreDto createdFakeStoreProduct = restTemplate.postForObject(
                url+"/products/",
                fakeStoreProduct,
                FakeStoreDto.class);

        return product;
    }

    public Product updateProduct(Product product, Long id){
        FakeStoreDto fakeStoreProduct = new FakeStoreDto();
        fakeStoreProduct.setTitle(product.getTitle());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageURL());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        restTemplate.put(url+"/products/"+id,fakeStoreProduct);
        return product;
    }

    public FakeStoreDto deleteProduct(@PathVariable Long id) {
        FakeStoreDto product = getProductById(id);
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        return product;
    }
}
