package com.torukobyte.bootcampproject.business.dto.responses.users.employees;

import com.torukobyte.bootcampproject.business.dto.responses.users.GetAllUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeResponse extends GetAllUserResponse {
    private String position;
}
