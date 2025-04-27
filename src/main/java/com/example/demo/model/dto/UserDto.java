package com.example.demo.model.dto;

import com.example.demo.model.constant.Role;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    @NotBlank(message = "Can not blank")
    private String username;

    @NotBlank(message = "Can not blank")
    @Size(min = 6)
    private String password;

    @NotBlank(message = "Can not blank")
    @Size(min = 10)
    private String email;

    @NotBlank(message = "Can not blank")
    @Size(min = 10 , max = 11)

    private String phone;

}
