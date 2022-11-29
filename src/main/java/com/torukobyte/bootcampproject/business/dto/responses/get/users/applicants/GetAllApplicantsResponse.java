package com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants;

import com.torukobyte.bootcampproject.business.dto.responses.get.users.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicantsResponse extends GetAllUsersResponse {
    private String about;
}
