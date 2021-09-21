package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.IssueReport;

@Controller
public class IssuController {

	@GetMapping("/issueReport")
	public String getReports(Model model) {
		model.addAttribute("issueReport", new IssueReport());
		return "issues/issueReport_form";
	}
	
	@PostMapping("/issueReport")
	@ResponseBody
	public String submitReport(Model model) {
		model.addAttribute("issueReport", new IssueReport());
		model.addAttribute("submitted", Boolean.TRUE);
		return "issues/issueReport_form";
	}
	
	@GetMapping("/issues")
	public String getIssues(Model model) {
		return "/issues/issueReport_list";
	}
}
