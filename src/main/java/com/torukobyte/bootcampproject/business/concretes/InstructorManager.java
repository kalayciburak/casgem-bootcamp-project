package com.torukobyte.bootcampproject.business.concretes;

import com.torukobyte.bootcampproject.business.abstracts.InstructorService;
import com.torukobyte.bootcampproject.business.dto.requests.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.entities.users.Instructor;
import com.torukobyte.bootcampproject.repository.abstracts.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository repository;
    private ModelMapperService mapper;

    @Override
    public List<GetAllInstructorResponse> getAll() {
        List<Instructor> instructors = repository.findAll();
        List<GetAllInstructorResponse> response = instructors
                .stream()
                .map(instructor -> mapper.forResponse().map(instructor, GetAllInstructorResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetInstructorResponse getById(int id) {
        Instructor instructor = repository.findById(id).orElseThrow();
        GetInstructorResponse response = mapper.forResponse().map(instructor, GetInstructorResponse.class);

        return response;
    }

    @Override
    public CreateInstructorResponse add(CreateInstructorRequest request) {
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        instructor.setId(0);
        repository.save(instructor);
        CreateInstructorResponse response = mapper.forResponse().map(instructor, CreateInstructorResponse.class);

        return response;
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest request, int id) {
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        instructor.setId(id);
        repository.save(instructor);
        UpdateInstructorResponse response = mapper.forResponse().map(instructor, UpdateInstructorResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
