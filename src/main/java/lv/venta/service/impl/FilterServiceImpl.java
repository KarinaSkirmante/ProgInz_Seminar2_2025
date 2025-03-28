package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	@Autowired
	private ICourseRepo couRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
		if(id <= 0){
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!studRepo.existsById(id)) {//ja students ar tadu id neeksistē
			throw new Exception("Students ar id: " + id + " neeksistē");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentStId(id);
		
		if(result.isEmpty()) {
			throw new Exception("Studentam ar id: " + id + " nav piesaistīta ne viena atzīme");
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id <= 0){
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!studRepo.existsById(id)) {//ja students ar tadu id neeksistē
			throw new Exception("Students ar id: " + id + " neeksistē");
		}
		
		ArrayList<Course> result = couRepo.findByGradesStudentStId(id);
		if(result.isEmpty()) {
			throw new Exception("Studentam ar id: " + id + " nav piesaistīts ne viens kurss");
		}
		
		return result;
		
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception {
		if(id <= 0){
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!profRepo.existsById(id)) {
			throw new Exception("Professors ar id: " + id + " neeksistē");
		}
		
		ArrayList<Course> result = couRepo.findByProfessorPId(id);
		
		if(result.isEmpty()) {
			throw new Exception("Professoram ar id: " + id + " nav piesaistīts neviens kurss");
		}
		
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
