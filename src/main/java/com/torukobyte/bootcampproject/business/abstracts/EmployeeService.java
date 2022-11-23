package com.torukobyte.bootcampproject.business.abstracts;

import com.torukobyte.bootcampproject.business.dto.requests.employees.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.employees.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.employees.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetAllEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAll();
    GetEmployeeResponse getById(int id);
    CreateEmployeeResponse add(CreateEmployeeRequest request);
    UpdateEmployeeResponse update(UpdateEmployeeRequest request, int id);
    void delete(int id);
}
