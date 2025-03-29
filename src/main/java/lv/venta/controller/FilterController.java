package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Grade;
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

	//TODO
	//getmapping
	//funkcijas deklarācija
	//izsaukt atbilstošo servisa funkciju -> selectCoursesByStudentId
	//uztaisīt try un catch bloku
	//catch bloka caur moedl.addatribute padot izņemuma ziņu
	//parādīt show-error-lapu
	//try bloka pēc selectCoursesByStudentId izsaukuma ar model.addAtribute ielikt atlasītos datus
	//parādīt show-courses-page

	//izveidot show-courses-page lapu
	
	
}
