package br.com.diogo.dao;

import java.util.Collection;

import br.com.diogo.entity.StudentEntity;

public interface StudentDaoInterface {

	Collection<StudentEntity> getAllStudents();

	StudentEntity getStudentById(int id);

	Boolean removeStudentById(int id);

	Boolean updateStudent(StudentEntity student);

	Boolean insertStudentToDb(StudentEntity student);

}