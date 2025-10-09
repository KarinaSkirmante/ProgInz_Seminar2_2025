package lv.venta.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.service.impl.EmailSendingServiceImpl;

@Controller
public class EmailTestController {
	@Autowired
	private EmailSendingServiceImpl emailService = new EmailSendingServiceImpl();
	
	@GetMapping("/send-email")
	public String getEmailSend(Model model) {
ArrayList<String> emails = new ArrayList<>(Arrays.asList("karina.krinkele@venta.lv", "s24kravguna@venta.lv", "s24pekskris@venta.lv"));
		for(String tempE: emails)
		{
		emailService.sendSimpleMsg(tempE,
				"karina.krinkele@gmail.lv", "Sveiciens no ProgInz II kursa",
				"Sveiki!\n\n Šo epastu Jums sūta Karina!\n\n Lai Jums jauka diena!", 
				new File("/home/karina.krinkele@vea.lv/git/ProgInz_Seminar2_2025/src/main/resources/code.jpg"));
		}
		model.addAttribute("package", "Epasts uz vairākiem kontiem ir nosūtīts");
		return "data-page";
		
		
	}

}
