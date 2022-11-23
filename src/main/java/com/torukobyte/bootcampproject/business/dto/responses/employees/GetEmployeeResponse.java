package com.torukobyte.bootcampproject.business.dto.responses.employees;

import com.torukobyte.bootcampproject.business.dto.responses.GetResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse extends GetResponse {
    private String position;
}
