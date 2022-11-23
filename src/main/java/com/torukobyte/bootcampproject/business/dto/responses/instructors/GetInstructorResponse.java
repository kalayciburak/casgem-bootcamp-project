package com.torukobyte.bootcampproject.business.dto.responses.instructors;

import com.torukobyte.bootcampproject.business.dto.responses.GetResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInstructorResponse extends GetResponse {
    private String companyName;
}
