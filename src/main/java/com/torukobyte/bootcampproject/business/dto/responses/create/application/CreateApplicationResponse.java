package com.torukobyte.bootcampproject.business.dto.responses.create.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationResponse {
    private int id;
    private int bootcampId;
    private int applicantId;
    private int state;
}

