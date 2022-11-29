package com.torukobyte.bootcampproject.business.dto.responses.update.blacklist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlacklistResponse {
    private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
}
