package com.torukobyte.bootcampproject.business.dto.responses.update.users.employee;

import com.torukobyte.bootcampproject.business.dto.responses.update.users.UpdateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResponse extends UpdateUserResponse {
    private String position;
}
