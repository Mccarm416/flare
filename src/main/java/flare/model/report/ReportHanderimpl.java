package flare.model.report;

import java.util.List;
import java.util.Map;
import flare.model.report.ReportDAO;
import org.springframework.beans.factory.annotation.Autowired;
 
public class ReportHanderimpl implements ReportHandler {
	
	@Autowired
	private ReportDAO reportDao;
 
	public void setCanvasjsChartDao(ReportDAO reportDao) {
		this.reportDao = reportDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getReportsjsChartData() {
		return  reportDao.getReportDAOChartData();
	}

}
