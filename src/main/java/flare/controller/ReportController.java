package flare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import flare.model.report.CanvasjsChartData.DataPointModel;
import flare.model.report.CanvasjsChartData.DatabaseConnectionException;
import flare.model.report.services.CanvasjsChartService;



@Controller
@RequestMapping("/Reports")
public class ReportController {
 
	@Autowired
	@Qualifier("chartsvc")
	private CanvasjsChartService canvasjsChartService;
 
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<List<DataPointModel>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "Reports";
	}
	
	@ExceptionHandler({DatabaseConnectionException.class})
	public ModelAndView getSuperheroesUnavailable(DatabaseConnectionException ex) {
	    return new ModelAndView("chart", "error", ex.getMessage());
	}
 
	
	
} 
