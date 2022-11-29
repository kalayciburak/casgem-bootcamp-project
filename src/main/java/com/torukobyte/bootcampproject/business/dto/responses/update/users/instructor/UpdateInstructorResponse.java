package com.torukobyte.bootcampproject.business.dto.responses.update.users.instructor;

import com.torukobyte.bootcampproject.business.dto.responses.update.users.UpdateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInstructorResponse extends UpdateUserResponse {
    private String companyName;
}
