package com.torukobyte.bootcampproject.business.dto.responses.create.users.instructor;

import com.torukobyte.bootcampproject.business.dto.responses.create.users.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstructorResponse extends CreateUserResponse {
    private String companyName;
}
