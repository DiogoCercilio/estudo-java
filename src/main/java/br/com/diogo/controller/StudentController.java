package br.com.diogo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogo.entity.StudentEntity;
import br.com.diogo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<StudentEntity> getAllStudents() {
		return this.studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public StudentEntity getStudentById(@PathVariable("id") int id) {
		return this.studentService.getStudentById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removeStudentById(@PathVariable("id") int id) {
		if(this.studentService.removeStudentById(id)) {
			return "Registro removido com sucesso";
		}
		return "Erro ao remover o registro";
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody StudentEntity student) {
		if(this.studentService.updateStudent(student)) {
			return "Registro atualizado com sucesso!";
		}
		return "Erro ao atualizar o registro";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertStudent(@RequestBody StudentEntity student) {
		if(this.studentService.insertStudent(student)) {
			return "Estudante cadastrado com sucesso";
		}
		return "Erro ao cadastrar estudante";
	}	
}
