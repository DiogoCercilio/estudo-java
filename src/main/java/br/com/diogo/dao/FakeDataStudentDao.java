package br.com.diogo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.diogo.entity.StudentEntity;

@Repository
@Qualifier("fakeData")
public class FakeDataStudentDao implements StudentDaoInterface {

	private static Map<Integer, StudentEntity> students;

	static {
		students = new HashMap<Integer, StudentEntity>() {
			{
				put(1, new StudentEntity(1, "Diogo", "Computer Science"));
				put(2, new StudentEntity(2, "João", "Direito"));
				put(3, new StudentEntity(3, "Maria", "Pedagogia"));				
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see br.com.diogo.dao.StudentDaoInterface#getAllStudents()
	 */
	@Override
	public Collection<StudentEntity> getAllStudents() {
		return students.values();
	}
	
	/* (non-Javadoc)
	 * @see br.com.diogo.dao.StudentDaoInterface#getStudentById(int)
	 */
	@Override
	public StudentEntity getStudentById(int id) {
		return students.get(id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.diogo.dao.StudentDaoInterface#removeStudentById(int)
	 */
	@Override
	public Boolean removeStudentById(int id) {
		students.remove(id);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see br.com.diogo.dao.StudentDaoInterface#updateStudent(br.com.diogo.entity.StudentEntity)
	 */
	@Override
	public Boolean updateStudent(StudentEntity student) {		
		StudentEntity s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		
		students.put(student.getId(), s);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see br.com.diogo.dao.StudentDaoInterface#insertStudentToDb(br.com.diogo.entity.StudentEntity)
	 */
	@Override
	public Boolean insertStudentToDb(StudentEntity student) {
		students.put(student.getId(), student);
		return true;
	}	
}
