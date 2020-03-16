package com.pea.checkinwork.demo.Repository;

import com.pea.checkinwork.demo.Entity.Pointage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PointageRepository extends JpaRepository<Pointage,Long> {
    Optional<Pointage> findById(Long id);

}