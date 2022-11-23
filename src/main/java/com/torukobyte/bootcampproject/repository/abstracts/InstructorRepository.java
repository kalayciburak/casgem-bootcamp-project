package com.torukobyte.bootcampproject.repository.abstracts;

import com.torukobyte.bootcampproject.entities.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
