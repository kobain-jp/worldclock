package com.dojo.worldclock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorldClockController {

	@GetMapping("/world-clock")
	public String index(Model model) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E HH:mm");
		String dateStr = sdf.format(date);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		model.addAttribute("jpDate", dateStr);

		// timezone インド
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		model.addAttribute("istDate", sdf.format(date));

		// timezone 中国
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		model.addAttribute("cstDate", sdf.format(date));

		return "index";
	}

}
