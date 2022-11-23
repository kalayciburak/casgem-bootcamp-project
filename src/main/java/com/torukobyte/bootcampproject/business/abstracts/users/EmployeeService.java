package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.users.employees.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.employees.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.GetAllEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.UpdateEmployeeResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> getById(int id);
    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request);
    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request, int id);
    Result delete(int id);
}
