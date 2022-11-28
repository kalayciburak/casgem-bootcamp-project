package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<GetInstructorResponse> getById(int id);
    DataResult<CreateInstructorResponse> add(CreateInstructorRequest request);
    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request, int id);
    Result delete(int id);
    Result changePassword(String oldPassword, String newPassword, String confirmPassword, int id);
    void checkIfInstructorExistById(int id);
}
