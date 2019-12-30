package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.students.Student;
import com.example.demo.students.StudentRepository;

/*
Zadanie 1: Page Controller
Uzupełnij plik template dla metody showStudents by wyświetlała studentów
Uzupełnij metody „addStudent”.
-addStudentForm ma wyświetlać formularz w którym będzie można dodać studenta za pomocą firstName i lastName.
-addStudentSubmit ma zapisywać studenta wpisanego w formularzu do bazy danych. Po zapisie ma wyświetlić formularz,
by można ewentualnie było dodać kolejnego studenta

Uzupełnij metody „updateStudent”.
-updateStudentForm ma wyświetlać formularz w którym będzie można zaktualizować studenta za pomocą id, firstName i lastName.
-updateStudentSubmit ma aktualizować studenta wpisanego w formularzu w bazie danych. Po aktualizacji ma wyświetlić
formularz, by można ewentualnie było zaktualizować kolejnego studenta

Stwórz metody „deleteStudent”
-deleteStudentForm ma wyświetlać formularz w którym będzie można usunąć studenta za pomocą id
-deleteStudentSubmit ma usuwać studenta wpisanego w formularzu z bazy danych. Po usunięciu ma wyświetlić formularz,
by można ewentualnie było usunąć kolejnego studenta
*/
@Controller
public class PageController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "showStudents";
    }

    @GetMapping("addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("addStudent")
    public String addStudentSubmit(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "addStudent";
    }

    @GetMapping("updateStudent")
    public String updateStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "updateStudent";
    }

    @PostMapping("updateStudent")
    public String updateStudentSubmit(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "updateStudent";
    }

    @GetMapping("deleteStudent")
    public String deleteStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "deleteStudent";
    }

    @PostMapping("deleteStudent")
    public String deleteStudentSubmit(@ModelAttribute Student student) {
        studentRepository.deleteById(student.getId());
        //studentRepository.delete(student);
        return "deleteStudent";
    }
}
