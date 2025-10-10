package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lv.venta.service.IPDFCreatorService;

@Controller
public class PDFCreatorTestController {
	
	@Autowired
	private IPDFCreatorService pdfService;
	
	
	@GetMapping("/pdf/{studid}/{courseid}")//localhost:8080/pdf/1/2
	public String getPDFController(Model model, @PathVariable(name = "studid") int studid,
			@PathVariable(name = "courseid") int courseid) {
		try
		{
			pdfService.createCertificateAsPDF(studid, courseid);
			model.addAttribute("package", "PDF ir izveidots");
			return "data-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";
		}
		
		
	}

}
