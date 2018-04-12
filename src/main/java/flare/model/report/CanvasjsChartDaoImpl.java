package flare.model.report;

import java.util.List;
import java.util.Map;
 
import flare.model.report.CanvasjsChartData;
 
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}  
