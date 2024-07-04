package com.example.fnx.springstudent.controllers;

import com.example.fnx.springstudent.model.Student;
import com.example.fnx.springstudent.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody - сериализация в json любого возвращаемого объекта
//@RestController - Controller + ResponseBody
//@RequestMapping - принимает строку в качестве параметра

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> findAllStudent (){
        return service.findAllStudent();
    }

    //@RequestBody сериализует запрашиваемый объект для работы с ним
    @PostMapping("save_student")
    public String saveStudent (@RequestBody Student student){
        service.saveStudent(student);
        return "success";
    }

    @GetMapping("/{email}")
    public Student findByEmail (@PathVariable String email){
        return service.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent (@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent (@PathVariable String email){
        service.deleteStudent(email);
    }
}
