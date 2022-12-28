package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.create.users.employee.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.employee.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.employee.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.employees.GetAllEmployeesResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.employee.UpdateEmployeeResponse;
import com.torukobyte.bootcampproject.core.utils.results.DataResult;
import com.torukobyte.bootcampproject.core.utils.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetAllEmployeesResponse>> getAll();
    DataResult<GetEmployeeResponse> getById(int id);
    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request);
    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request, int id);
    Result delete(int id);
    Result changePassword(ChangeUserPasswordRequest request, int id);
    void checkIfUserIsEmployee(int id);
}
