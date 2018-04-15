package flare.model.report;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import flare.model.report.CanvasjsChartData;

import flare.model.report.CanvasjsChartData.DataPointModel;
 
@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<DataPointModel>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}  
