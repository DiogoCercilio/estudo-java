package br.com.diogo.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.diogo.entity.StudentEntity;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImplementation implements StudentDaoInterface {

//	Connection mongoConnection;
	
	@Override
	public Collection<StudentEntity> getAllStudents() {
		return new ArrayList<StudentEntity>() {
			{
				add(new StudentEntity(1, "Mario", "Nothing"));
			}
		};
	}

	@Override
	public StudentEntity getStudentById(int id) {
		return null;
	}

	@Override
	public Boolean removeStudentById(int id) {
		return null;
	}

	@Override
	public Boolean updateStudent(StudentEntity student) {
		return null;
	}

	@Override
	public Boolean insertStudentToDb(StudentEntity student) {
		return null;
	}

}
