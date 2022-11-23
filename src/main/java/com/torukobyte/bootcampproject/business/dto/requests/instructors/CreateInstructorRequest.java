package com.torukobyte.bootcampproject.business.dto.requests.instructors;

import com.torukobyte.bootcampproject.business.dto.requests.CreateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstructorRequest extends CreateRequest {
    private String companyName;
}