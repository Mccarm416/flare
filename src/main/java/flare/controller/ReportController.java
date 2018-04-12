package flare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import flare.model.report.ReportHandler;

@Controller
@RequestMapping("/report")
public class ReportController {


	@Autowired
	private ReportHandler reportHandler;
 
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = reportHandler.getReportsjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "Reports";
	}
	
	/*
	@RequestMapping("/rr")
	public String showpage() {
		return "Reports";
	}
	*/
	
	/*
	@RequestMapping("/jschart")
	public class JsChartController {
	 
		
	}  */    
	

	
} 
