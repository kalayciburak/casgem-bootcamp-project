package com.torukobyte.bootcampproject.business.dto.responses.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
    private int id;
    private String firstName;
    private LocalDate dateOfBirth;
    private String nationalIdentity;
    private String lastName;
    private String email;
}
