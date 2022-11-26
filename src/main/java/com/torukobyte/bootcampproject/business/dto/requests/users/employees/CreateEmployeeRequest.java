package com.torukobyte.bootcampproject.business.dto.requests.users.employees;

import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import com.torukobyte.bootcampproject.business.dto.requests.users.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest extends CreateUserRequest {
    @NotBlank(message = ValidationMessages.Employee.PositionBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.Employee.PositionValid)
    private String position;
}