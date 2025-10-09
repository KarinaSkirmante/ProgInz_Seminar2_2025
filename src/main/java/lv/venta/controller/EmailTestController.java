package lv.venta.controller;

import java.util.ArrayList;

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

		
		emailService.sendSimpleMsg("karina.krinkele@venta.lv",
				"karina.krinkele@gmail.lv", "Sveiciens no ProgInz II kursa",
				"Sveiki!\n\n Šo epastu Jums sūta Karina!\n\n Lai Jums jauka diena!", null);
		
		model.addAttribute("package", "Epasts uz karina.krinkele@venta.lv ir nosūtīts");
		return "data-page";
		
		
	}

}
