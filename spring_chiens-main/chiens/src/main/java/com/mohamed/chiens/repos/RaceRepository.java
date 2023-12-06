package com.mohamed.chiens.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mohamed.chiens.entities.Race;

@RepositoryRestResource(path = "Rc")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface RaceRepository extends JpaRepository<Race, Long> {

}
