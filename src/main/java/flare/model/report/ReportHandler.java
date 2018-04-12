package flare.model.report;

import java.util.List;
import java.util.Map;
import flare.model.report.ReportDAO;
public interface ReportHandler {
	
	List<List<Map<Object, Object>>> getReportsjsChartData();


}
