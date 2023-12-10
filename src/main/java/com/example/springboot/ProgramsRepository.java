package com.example.springboot;
import org.springframework.data.repository.CrudRepository;



public interface ProgramsRepository extends CrudRepository<Programs, Long> {
    Programs findProgramsByPid(Long pid);
}
