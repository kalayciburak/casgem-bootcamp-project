package com.torukobyte.bootcampproject.business.dto.requests.users.instructors;

import com.torukobyte.bootcampproject.business.dto.requests.users.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstructorRequest extends CreateUserRequest {
    private String companyName;
}