package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {

	@Autowired
	private IFilterService filtService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/filter/grades/student/1
	public String getControllerGetAllGradesForStudent(@PathVariable (name = "id") int id, Model model)
	{
		try
		{
			ArrayList<Grade> filteredGrades = filtService.selectGradesByStudentId(id);
			model.addAttribute("package", filteredGrades);
			return "show-grades-page";//parādīs show-grades-page.html lapu ar izfiltrētām atzīmēm
		}catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums
		}
	}

	@GetMapping("/courses/student/{id}")//localhost:8080/filter/courses/student/1
	public String getControllerGetAllCoursesForStudent(@PathVariable(name = "id") int id, Model model)
	{
		try
		{
			ArrayList<Course> filteredCourses = filtService.selectCoursesByStudentId(id);
			model.addAttribute("package", filteredCourses);
			return "show-courses-page";//parādīs show-courses-page.html lapu ar izfiltrētime kursiem
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums

		}
		
	}
	@GetMapping("/courses/professor/{id}")//localhost:8080/filter/courses/professor/1
	public String getControllerGetAllCoursesForprofessor(@PathVariable(name = "id") int id, Model model)
	{
		try
		{
			ArrayList<Course> filteredCourses = filtService.selectCoursesByProfessorId(id);
			model.addAttribute("package", filteredCourses);
			return "show-courses-page";//parādīs show-courses-page.html lapu ar izfiltrētime kursiem
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums

		}
		
	}
	
	@GetMapping("/grades/avg/course/{id}")//localhost:8080/filter/grades/avg/course/1
	public String getControllerGetAvgGradeInCourse(@PathVariable(name = "id") int id, Model model)
	{
		try
		{
			float avgGrade = filtService.calculateAVGGradeInCourseId(id);
			model.addAttribute("package", ("Vidējā atzīmju vērtība ir " + avgGrade));
			return "data-page";//parādīs data-page.html lapu ar vidējo vērtību konkrētajā kursā
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums

		}
		
	}
	
	@GetMapping("/students/failed")//localhost:8080/filter/students/failed
	public String getControllergetFailedStudents(Model model)
	{
		try
		{
			ArrayList<Student> failedStudents = filtService.selectAllStudentsWithFailedGrades();
			model.addAttribute("package", failedStudents);
			return "show-students-page";//parādīs show-students-page.html lapu ar izfiltrētajiem studentiem
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";//parādīt show-error-page.html lapu, kura būs kļudas ziņojums
		}
	}
	
	
}
