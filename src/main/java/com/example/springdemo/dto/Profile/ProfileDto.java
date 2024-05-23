package com.example.springdemo.dto.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    public String name;
    public String surname;
    public String phoneNumber;
    public String email;
    public String role;
    public String password;
}
