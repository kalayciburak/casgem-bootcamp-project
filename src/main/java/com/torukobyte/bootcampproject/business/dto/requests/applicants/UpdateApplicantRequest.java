package com.torukobyte.bootcampproject.business.dto.requests.applicants;

import com.torukobyte.bootcampproject.business.dto.requests.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicantRequest extends UpdateRequest {
    private String about;
}
