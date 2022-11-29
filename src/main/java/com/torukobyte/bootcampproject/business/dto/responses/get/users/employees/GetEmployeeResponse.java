package com.torukobyte.bootcampproject.business.dto.responses.get.users.employees;

import com.torukobyte.bootcampproject.business.dto.responses.get.users.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse extends GetUserResponse {
    private String position;
}
