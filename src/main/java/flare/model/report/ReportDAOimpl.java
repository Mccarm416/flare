package flare.model.report;
 
	import java.util.List;
	import java.util.Map;
	
	import flare.model.report.Report;
	 
	public class ReportDAOimpl implements ReportDAO {
	 
		
		public List<List<Map<Object, Object>>> getReportDAOChartData() {
			return Report.getReportjsDataList();
		}
	

}
