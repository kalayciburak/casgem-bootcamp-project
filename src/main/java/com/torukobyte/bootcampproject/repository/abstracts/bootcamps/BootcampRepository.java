package com.torukobyte.bootcampproject.repository.abstracts.bootcamps;

import com.torukobyte.bootcampproject.entities.bootcamps.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
}
