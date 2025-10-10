package lv.venta.service.impl;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IPDFCreatorService;

@Service
public class PDFCreatorServiceImpl implements IPDFCreatorService{

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public void createCertificateAsPDF(int studId, int courseId) throws Exception {
		
		if(!studRepo.existsById(studId)) {
			throw new Exception("Students ar id: " + studId + " neeksistē");
		}
		
		if(!courseRepo.existsById(courseId)){
			throw new Exception("Kurss ar id: " + courseId + " neeksistē");
		}
		
		Grade gradeFromDB = gradeRepo.findByStudentStidAndCourseCid(studId, courseId);
		
		if(gradeFromDB == null) {
			throw new Exception("Studentam ar id: " + studId + " neeksistē atzīme kursā ar id: " + courseId);
		}
		else
		{
			if(gradeFromDB.getGrvalue() < 4) {
				throw new Exception("Studentam ar id: " + studId + 
						" nav sekmīgi nokārtots kurss ar id: " + courseId);
			}
			else
			{
				String studentNameAndSurname = gradeFromDB.getStudent().getName() + " " + 
						gradeFromDB.getStudent().getSurname();
				
				String courseTitle = gradeFromDB.getCourse().getTitle();
				
				int grade = gradeFromDB.getGrvalue();
				
				Random random = new Random();
				int certicateNo = random.nextInt(100000, 999999);
				int hours = gradeFromDB.getCourse().getCreditpoints()*16/2;
				LocalDate date = LocalDate.now();
				
				//TODO arī citus datus var ievākt (ja nepieciešams)
				
				Document document = new Document();
				
				
				PdfWriter writer = PdfWriter.getInstance(document, 
						new FileOutputStream(certicateNo + "_" + studentNameAndSurname+".pdf"));
				
				Paragraph p1 = new Paragraph("TestDevLab Skola",  
						FontFactory.getFont(FontFactory.COURIER, 18));
				
				
				document.open();
				p1.setAlignment(Element.ALIGN_CENTER);
				document.add(p1);
				
				document.add(new Paragraph("CERTIFICATE", FontFactory.getFont(FontFactory.COURIER, 25)));
				document.add(new Paragraph("No." + certicateNo, FontFactory.getFont(FontFactory.COURIER, 22)));
				document.add(new Paragraph(studentNameAndSurname, FontFactory.getFont(FontFactory.COURIER, 22)));
				document.add(new Paragraph("has mastered non-formal education program", FontFactory.getFont(FontFactory.COURIER, 18)));
				document.add(new Paragraph(courseTitle, FontFactory.getFont(FontFactory.COURIER, 22)));
				document.add(new Paragraph(hours + " hours\n\n\n",FontFactory.getFont(FontFactory.COURIER, 18)));
				document.add(new Paragraph("Assessment: "+grade+" out of 10", FontFactory.getFont(FontFactory.COURIER, 22)));
				document.add(new Paragraph(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), FontFactory.getFont(FontFactory.COURIER, 22)));
				
				
				
				document.close();
			}
		}
		
		
	}

}
