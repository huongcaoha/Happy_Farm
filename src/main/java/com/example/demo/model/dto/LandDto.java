package com.example.demo.model.dto;

import com.example.demo.model.constant.TypeLand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LandDto {
    @NotBlank(message = "Name land can not blank")
    private String nameLand ;

    @NotBlank(message = "Type land can not null")
    private String typeLand;

    @NotNull(message = "Price can not null")
    @Min(1)
    private double price ;

    @NotNull(message = "Can not null")
    @Min(1)
    private float efficiency ;

    @NotBlank(message = "Can not blank")
    private String description ;

    @NotBlank(message = "Can not blank")
    private String image ;
}
