package com.torukobyte.bootcampproject.repository.abstracts;

import com.torukobyte.bootcampproject.entities.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
}
