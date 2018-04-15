package flare.model.report;

import java.util.List;
import java.util.Map;

import flare.model.report.CanvasjsChartData.DataPointModel;

public interface CanvasjsChartDao {

	List<List<DataPointModel>>  getCanvasjsChartData();

}
