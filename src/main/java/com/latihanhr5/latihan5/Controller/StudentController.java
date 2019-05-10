package com.latihanhr5.latihan5.Controller;

import com.latihanhr5.latihan5.Exception.CustomException;
import com.latihanhr5.latihan5.Model.Student;
import com.latihanhr5.latihan5.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class StudentController {

    @Autowired
    private StudentRepo studentrepo;

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentrepo.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id){
        Optional<Student> student = studentrepo.findById(id);
        if(student.isPresent()){
            return student.get();
        }else{
            throw new CustomException("Student With Id: "+id +" not Exist");
        }

    }

    @PostMapping("/student")
    public Student savestd(@RequestBody final Student std){
        return studentrepo.save(std);
    }
    @PutMapping("/student/{id}")
    public Student updatestd (@PathVariable Long id, @Valid @RequestBody Student std ){
        return studentrepo.findById(id).map(x ->{
                x.setName(std.getName());
                x.setAge(std.getAge());
                return studentrepo.save(x);
        }).orElseThrow(() -> new CustomException(("Student Not Found")));
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentrepo.findById(id).map(student -> {
            studentrepo.delete(student);
            return "delete success";
        }).orElseThrow(() -> new CustomException("Student Not Found"));
    }
}
