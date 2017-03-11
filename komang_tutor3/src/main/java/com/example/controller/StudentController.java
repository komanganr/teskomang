package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.InMemoryStudentService;
import com.example.service.StudentService;
import com.example.model.Student;

@Controller
public class StudentController {
	private final StudentService studentService;

	public StudentController() {
		studentService = new InMemoryStudentService();
	}

	@RequestMapping("/student/add")
	public String add(@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		Student student = new Student(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
	}

	@RequestMapping("/student/view")
	public String view(Model model, @RequestParam(value = "npm", required = true) String npm) {
		Student student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
	
	@RequestMapping("/student/view/{npm}")
	public String greetingPath (@PathVariable String npm,
	Model model)
	{
	Student student = studentService.selectStudent(npm);
	model.addAttribute("student", student);
	return "view";
	}

	@RequestMapping("/student/viewall")
	public String view(Model model) {
		List<Student> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		return "viewall";
	}
}