package com.torukobyte.bootcampproject.business.abstracts;

import com.torukobyte.bootcampproject.business.dto.requests.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.UpdateInstructorResponse;

import java.util.List;

public interface InstructorService {
    List<GetAllInstructorResponse> getAll();
    GetInstructorResponse getById(int id);
    CreateInstructorResponse add(CreateInstructorRequest request);
    UpdateInstructorResponse update(UpdateInstructorRequest request, int id);
    void delete(int id);
}
