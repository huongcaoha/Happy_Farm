package com.example.demo.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SeedsDto {
    @NotBlank(message = "Can not blank")
    private String seedsName;

    @NotNull(message = "Can not null")
    @Min(1)
    private double price;

    @NotNull(message = "Can not null")
    @Min(5)
    private int developmentTime ;

    @NotBlank(message = "Can not blank")
    private String description ;

    @NotNull(message = "Can not null")
    @Min(5)
    private double postHarvestPrice ;

    @NotBlank(message = "Can not blank")
    private String image ;
}
