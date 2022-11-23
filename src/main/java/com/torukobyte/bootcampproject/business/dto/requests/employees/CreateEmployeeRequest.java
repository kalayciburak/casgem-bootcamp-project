package com.torukobyte.bootcampproject.business.dto.requests.employees;

import com.torukobyte.bootcampproject.business.dto.requests.CreateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest extends CreateRequest {
    private String position;
}