package com.trading.income.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
