package com.example.imageconventer.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDto {
   private String userName;
   private String password;
   private String email;
   private String error;
}
