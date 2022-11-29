package com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants;

import com.torukobyte.bootcampproject.business.dto.responses.get.users.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicantResponse extends GetUserResponse {
    private String about;
}
