package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    @NotBlank(message = "用户名不为空")
    @Pattern(regexp = "[0-9a-zA-Z\\xa0-\\xff_][0-9a-zA-Z\\xa0-\\xff_]{2,9}",message = "用户名不合法")
    private String username;

    @NotBlank(message = "密码不为空")
    @Size(min = 5,max = 12,message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
