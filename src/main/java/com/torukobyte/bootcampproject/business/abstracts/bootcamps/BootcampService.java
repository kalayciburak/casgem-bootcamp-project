package com.torukobyte.bootcampproject.business.abstracts.bootcamps;

import com.torukobyte.bootcampproject.business.dto.requests.create.bootcamp.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.bootcamp.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.bootcamp.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetAllBootcampsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.bootcamp.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.utils.results.DataResult;
import com.torukobyte.bootcampproject.core.utils.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<List<GetAllBootcampsResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);
    DataResult<CreateBootcampResponse> add(CreateBootcampRequest request);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest request, int id);
    Result delete(int id);
    void checkIfBootcampIsActive(int id);
    void checkIfBootcampExistById(int id);
}
