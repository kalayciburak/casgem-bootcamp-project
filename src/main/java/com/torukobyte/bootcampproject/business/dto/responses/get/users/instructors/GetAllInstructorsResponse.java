package com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors;

import com.torukobyte.bootcampproject.business.dto.responses.get.users.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllInstructorsResponse extends GetAllUsersResponse {
    private String companyName;
}
