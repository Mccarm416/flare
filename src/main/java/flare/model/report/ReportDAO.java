package flare.model.report;

import java.util.List;
import java.util.Map;


public interface ReportDAO  {

	List<List<Map<Object, Object>>> getReportDAOChartData();
	
}
