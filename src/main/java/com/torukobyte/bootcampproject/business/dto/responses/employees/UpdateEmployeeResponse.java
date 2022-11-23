package com.torukobyte.bootcampproject.business.dto.responses.employees;

import com.torukobyte.bootcampproject.business.dto.responses.UpdateResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResponse extends UpdateResponse {
    private String position;
}
