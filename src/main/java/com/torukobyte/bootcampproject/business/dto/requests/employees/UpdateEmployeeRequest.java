package com.torukobyte.bootcampproject.business.dto.requests.employees;

import com.torukobyte.bootcampproject.business.dto.requests.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest extends UpdateRequest {
    private String position;
}
