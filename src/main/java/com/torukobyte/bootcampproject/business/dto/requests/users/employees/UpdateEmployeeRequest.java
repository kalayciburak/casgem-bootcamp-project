package com.torukobyte.bootcampproject.business.dto.requests.users.employees;

import com.torukobyte.bootcampproject.business.dto.requests.users.UpdateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest extends UpdateUserRequest {
    private String position;
}
