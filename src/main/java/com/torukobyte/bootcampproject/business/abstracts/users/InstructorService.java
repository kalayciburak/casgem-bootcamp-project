package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.create.users.instructor.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.instructor.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.instructor.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetAllInstructorsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.instructor.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorsResponse>> getAll();
    DataResult<GetInstructorResponse> getById(int id);
    DataResult<CreateInstructorResponse> add(CreateInstructorRequest request);
    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request, int id);
    Result delete(int id);
    Result changePassword(ChangeUserPasswordRequest request, int id);
    void checkIfInstructorExistById(int id);
}
