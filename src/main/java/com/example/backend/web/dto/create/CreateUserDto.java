package com.example.backend.web.dto.create;


import com.example.backend.business.enums.AuthorityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private AuthorityEnum authority;

}
