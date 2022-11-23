package com.torukobyte.bootcampproject.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
