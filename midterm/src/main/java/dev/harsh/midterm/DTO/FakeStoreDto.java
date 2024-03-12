package dev.harsh.midterm.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    private Long id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String imageUrl;
}
