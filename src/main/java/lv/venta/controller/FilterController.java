package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {

	@Autowired
	private IFilterService filtService;
	
	//TODO
	//izveidot Getmapping 
	//@GetMapping("/grades/student/{id}")
	//funkcijas deklarācija, ar PathVariable anotāciju, lai nolasītu id
	//izsaukt atbilstošo servisa funkciju -> selectGradesByStudentId
	//uztaisīt try un catch bloku
	//catch bloka caur moedl.addatribute padot izņemuma ziņu
	//parādīt show-error-lapu
	//try bloka pēc selectGradesByStudentId izsaukuma ar model.addAtribute ielikt atlasītos datus
	//parādīt show-course-page
	
	//izveidot show-error-page lapu
	//izveidot show-course-page lapu
	
	
}
