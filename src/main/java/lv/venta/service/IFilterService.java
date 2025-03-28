package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;

public interface IFilterService {
	
	public abstract ArrayList<Grade> selectGradesByStudentId(int id) throws Exception;
		
	public abstract ArrayList<Course> selectCoursesByStudentId(int id) throws Exception;

	public abstract ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(int id) throws Exception;
	
	public abstract ArrayList<Student> selectAllStudentsWithFailedGrades() throws Exception;
	
}
