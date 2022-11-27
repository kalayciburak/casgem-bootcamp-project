package com.torukobyte.bootcampproject.business.concretes.users;

import com.torukobyte.bootcampproject.business.abstracts.users.EmployeeService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.users.employees.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.employees.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.GetAllEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.employees.UpdateEmployeeResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.users.Employee;
import com.torukobyte.bootcampproject.repository.abstracts.users.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = repository.findAll();
        List<GetAllEmployeeResponse> data = employees
                .stream()
                .map(employee -> mapper.forResponse().map(employee, GetAllEmployeeResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Employee.ListAll);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        checkIfEmployeeExistById(id);
        Employee employee = repository.findById(id).orElseThrow();
        GetEmployeeResponse data = mapper.forResponse().map(employee, GetEmployeeResponse.class);

        return new SuccessDataResult<>(data, Messages.Employee.ListById);
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request) {
        checkIfEmployeeExistByNationalIdentity(request.getNationalIdentity());
        Employee employee = mapper.forRequest().map(request, Employee.class);
        repository.save(employee);
        CreateEmployeeResponse data = mapper.forResponse().map(employee, CreateEmployeeResponse.class);

        return new SuccessDataResult<>(data, Messages.Employee.Created);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request, int id) {
        checkIfEmployeeExistById(id);
        checkIfEmployeeExistByNationalIdentity(request.getNationalIdentity());
        Employee employee = mapper.forRequest().map(request, Employee.class);
        employee.setId(id);
        repository.save(employee);
        UpdateEmployeeResponse data = mapper.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<>(data, Messages.Employee.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfEmployeeExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Employee.Deleted);
    }

    @Override
    public void checkIfUserIsEmployee(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Employee.NotAnEmployee);
        }
    }

    private void checkIfEmployeeExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Employee.EmployeeNotExists);
        }
    }

    private void checkIfEmployeeExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsEmployeetByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Employee.EmployeeExists);
        }
    }
}
