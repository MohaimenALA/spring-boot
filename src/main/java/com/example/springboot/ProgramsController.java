package com.example.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramsController {

    @Autowired
    private ProgramsRepository programsRepository;

    // Add a particular program
    @PostMapping("/add")
    public ResponseEntity<Programs> addProgram(@RequestBody Programs program) {
        Programs addedProgram = programsRepository.save(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProgram);
    }

    // List all programs
    @GetMapping("/list")
    public ResponseEntity<List<Programs>> listPrograms() {
        List<Programs> programs = (List<Programs>) programsRepository.findAll();
        return ResponseEntity.ok(programs);
    }

    // View one program based on id
    @GetMapping("/view/{id}")
    public ResponseEntity<Programs> viewProgram(@PathVariable Long id) {
        Programs program = programsRepository.findById(id).orElse(null);
        if (program != null) {
            return ResponseEntity.ok(program);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Modify a program
    @PutMapping("/modify/{id}")
    public ResponseEntity<Programs> modifyProgram(@PathVariable Long id, @RequestBody Programs updatedProgram) {
        Programs program = programsRepository.findById(id).orElse(null);
        if (program != null) {
            program.setProgramName(updatedProgram.getProgramName());
            program.setCampus(updatedProgram.getCampus());

            Programs modifiedProgram = programsRepository.save(program);
            return ResponseEntity.ok(modifiedProgram);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a program
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id) {
        if (programsRepository.existsById(id)) {
            programsRepository.deleteById(id);
            return ResponseEntity.ok("Program deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
