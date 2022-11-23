package com.torukobyte.bootcampproject.business.concretes;

import com.torukobyte.bootcampproject.business.abstracts.EmployeeService;
import com.torukobyte.bootcampproject.business.dto.requests.employees.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.employees.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.employees.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetAllEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.UpdateEmployeeResponse;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.entities.users.Applicant;
import com.torukobyte.bootcampproject.entities.users.Employee;
import com.torukobyte.bootcampproject.repository.abstracts.ApplicantRepository;
import com.torukobyte.bootcampproject.repository.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository repository;
    private ModelMapperService mapper;

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = repository.findAll();
        List<GetAllEmployeeResponse> response = employees
                .stream()
                .map(
                        employee -> mapper.forResponse().map(employee, GetAllEmployeeResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = repository.findById(id).orElseThrow();
        GetEmployeeResponse response = mapper.forResponse().map(employee, GetEmployeeResponse.class);

        return response;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        Employee employee = mapper.forRequest().map(request, Employee.class);
        employee.setId(0);
        repository.save(employee);
        CreateEmployeeResponse response = mapper.forResponse().map(employee, CreateEmployeeResponse.class);

        return response;
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request, int id) {
        Employee employee = mapper.forRequest().map(request, Employee.class);
        employee.setId(id);
        repository.save(employee);
        UpdateEmployeeResponse response = mapper.forResponse().map(employee, UpdateEmployeeResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
