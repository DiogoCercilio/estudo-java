package br.com.diogo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.diogo.dao.StudentDaoInterface;
import br.com.diogo.entity.StudentEntity;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("fakeData")
	private StudentDaoInterface studentDao; 
	
	public Collection<StudentEntity> getAllStudents() {
		return this.studentDao.getAllStudents();
	}	
	
	public StudentEntity getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}
	
	public Boolean removeStudentById(int id) {
		return this.studentDao.removeStudentById(id);
	}
	
	public Boolean updateStudent(StudentEntity student) {		
		return this.studentDao.updateStudent(student);
	}
	
	public Boolean insertStudent(StudentEntity student) {		
		return this.studentDao.insertStudentToDb(student);
	}	
}
