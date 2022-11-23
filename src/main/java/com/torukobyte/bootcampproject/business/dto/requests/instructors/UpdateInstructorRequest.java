package com.torukobyte.bootcampproject.business.dto.requests.instructors;

import com.torukobyte.bootcampproject.business.dto.requests.UpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInstructorRequest extends UpdateRequest {
    private String companyName;
}
