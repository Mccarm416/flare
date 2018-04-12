//CanvasjsChartService.java
package flare.model.report.services;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
 

public interface CanvasjsChartService {
 
	List<List<Map<Object, Object>>> getCanvasjsChartData();
 
}