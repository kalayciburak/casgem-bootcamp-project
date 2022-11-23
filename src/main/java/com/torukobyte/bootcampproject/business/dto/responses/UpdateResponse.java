package com.torukobyte.bootcampproject.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
