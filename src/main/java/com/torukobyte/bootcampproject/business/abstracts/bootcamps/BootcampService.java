package com.torukobyte.bootcampproject.business.abstracts.bootcamps;

import com.torukobyte.bootcampproject.business.dto.requests.bootcamps.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.bootcamps.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.GetAllBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);
    DataResult<CreateBootcampResponse> add(CreateBootcampRequest request);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest request, int id);
    Result delete(int id);
    void checkIfBootcampIsActive(int id);
}
