//CanvasjsChartServiceImpl.java
package flare.model.report.services; 
 
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flare.model.report.CanvasjsChartDao;
@Component("chartsvc")
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
 
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return canvasjsChartDao.getCanvasjsChartData();
	}
 
} 