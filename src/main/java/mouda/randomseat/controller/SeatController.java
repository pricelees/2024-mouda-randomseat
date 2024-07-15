package mouda.randomseat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import mouda.randomseat.service.SeatService;

@Controller
@RequiredArgsConstructor
public class SeatController {
	private static final String DEFAULT_MEMBERS = "치코,안나,소파,수야,테니,테바,호기,상돌";
	private final SeatService seatService;

	@GetMapping("/health")
	@ResponseBody
	public String health() {
		return "<h1>health</h1>";
	}

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("names", "");
		return "index";
	}

	@PostMapping("/assignSeats")
	public String assignSeats(@RequestParam(required = false, defaultValue = DEFAULT_MEMBERS) String names,
		Model model) {
		List<String> result = seatService.assignSeat(names);
		model.addAttribute("names", result);
		return "result";
	}
}
