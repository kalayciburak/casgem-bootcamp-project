package com.torukobyte.bootcampproject.business.concretes.users;

import com.torukobyte.bootcampproject.business.abstracts.users.InstructorService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.users.Instructor;
import com.torukobyte.bootcampproject.repository.abstracts.users.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = repository.findAll();
        List<GetAllInstructorResponse> data = instructors
                .stream()
                .map(instructor -> mapper.forResponse().map(instructor, GetAllInstructorResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Instructor.ListAll);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        checkIfInstructorExistById(id);
        Instructor instructor = repository.findById(id).orElseThrow();
        GetInstructorResponse data = mapper.forResponse().map(instructor, GetInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.ListById);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfInstructorExistByNationalIdentity(request.getNationalIdentity());
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        repository.save(instructor);
        CreateInstructorResponse data = mapper.forResponse().map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.Created);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request, int id) {
        checkIfInstructorExistById(id);
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfInstructorExistByNationalIdentity(request.getNationalIdentity());
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        instructor.setId(id);
        repository.save(instructor);
        UpdateInstructorResponse data = mapper.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfInstructorExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Instructor.Deleted);
    }

    @Override
    public Result changePassword(String oldPassword, String newPassword, String confirmPassword, int id) {
        checkIfInstructorExistById(id);
        if (!repository.findById(id).get().getPassword().equals(oldPassword)) {
            throw new ValidationException(ValidationMessages.User.OldPasswordNotMatch);
        }
        if (oldPassword.equals(newPassword)) {
            throw new ValidationException(ValidationMessages.User.ThereIsNoChangeInPassword);
        }
        comparePassword(newPassword, confirmPassword);
        repository.changePassword(newPassword, id);

        return new SuccessResult(Messages.User.PasswordChanged);
    }

    @Override
    public void checkIfInstructorExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Instructor.InstructorNotExists);
        }
    }

    private void checkIfInstructorExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsInstructortByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Instructor.InstructorExists);
        }
    }

    private void comparePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(ValidationMessages.User.ConfirmPasswordValid);
        }
    }
}
