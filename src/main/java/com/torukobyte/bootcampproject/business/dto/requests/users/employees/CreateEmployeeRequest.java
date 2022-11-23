package com.torukobyte.bootcampproject.business.dto.requests.users.employees;

import com.torukobyte.bootcampproject.business.dto.requests.users.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest extends CreateUserRequest {
    private String position;
}