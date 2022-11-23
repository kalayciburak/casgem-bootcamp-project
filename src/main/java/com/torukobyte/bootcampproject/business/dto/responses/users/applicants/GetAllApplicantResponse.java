package com.torukobyte.bootcampproject.business.dto.responses.users.applicants;

import com.torukobyte.bootcampproject.business.dto.responses.users.GetAllUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicantResponse extends GetAllUserResponse {
    private String about;
}
