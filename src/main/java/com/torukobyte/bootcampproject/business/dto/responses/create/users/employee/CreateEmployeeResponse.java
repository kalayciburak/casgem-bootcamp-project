package com.torukobyte.bootcampproject.business.dto.responses.create.users.employee;

import com.torukobyte.bootcampproject.business.dto.responses.create.users.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeResponse extends CreateUserResponse {
    private String position;
}
