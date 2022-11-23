package com.torukobyte.bootcampproject.business.dto.responses.users.instructors;

import com.torukobyte.bootcampproject.business.dto.responses.users.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInstructorResponse extends GetUserResponse {
    private String companyName;
}
