package com.torukobyte.bootcampproject.api.controllers;

import com.torukobyte.bootcampproject.business.abstracts.EmployeeService;
import com.torukobyte.bootcampproject.business.dto.requests.employees.CreateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.requests.employees.UpdateEmployeeRequest;
import com.torukobyte.bootcampproject.business.dto.responses.employees.CreateEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetAllEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.GetEmployeeResponse;
import com.torukobyte.bootcampproject.business.dto.responses.employees.UpdateEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeesController {
    private EmployeeService service;

    @GetMapping
    List<GetAllEmployeeResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    GetEmployeeResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    UpdateEmployeeResponse update(@RequestBody UpdateEmployeeRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }
}
