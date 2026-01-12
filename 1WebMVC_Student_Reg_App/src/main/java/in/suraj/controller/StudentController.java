package in.suraj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.suraj.binding.Student;
import in.suraj.entity.StudentEntity;
import in.suraj.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo;

	@GetMapping("/")
	public String loadForm(Model model) {
		loadFormData(model);
		return ("index");
	}

	private void loadFormData(Model model) {
		List<String> coursesList = new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("DevOps");
		coursesList.add("AWS");
		coursesList.add("Python");

		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");
		Student student = new Student();
		model.addAttribute("courses", coursesList);
		model.addAttribute("timings", timingsList);
		model.addAttribute("student", student);

	}

	@PostMapping("/save")
	public String handelSubmit(Student student, Model model) {
		StudentEntity entity = new StudentEntity();

		BeanUtils.copyProperties(student, entity);

		entity.setTimings(Arrays.toString(student.getTimings()));

		repo.save(entity);

		model.addAttribute("msg", "Student saved");
		loadFormData(model);
		return "index";
	}

	@GetMapping("/viewsStudent")
	public String viewStudent(Model model) {

		List<StudentEntity> studentList = repo.findAll();
		model.addAttribute("students", studentList);

		return "data";

	}

}
