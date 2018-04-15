//CanvasjsChartService.java
package flare.model.report.services;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import flare.model.report.CanvasjsChartData.DataPointModel;
 

public interface CanvasjsChartService {
 
	List<List<DataPointModel>> getCanvasjsChartData();
 
}