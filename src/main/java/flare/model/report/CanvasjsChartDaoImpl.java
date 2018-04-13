package flare.model.report;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import flare.model.report.CanvasjsChartData;
 
@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}  
