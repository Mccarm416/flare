<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 	


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Card</title>
</head>


<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("studentChart", {
	theme: "light2",
	animationEnabled: true,
	title: {
		text: "[total time spent studying on X]"
	},
	axisX: {
		valueFormatString: "MMM"
	},
	axisY: {
		title: "Time (in minutes)",
		suffix: "M"
	},
	data: [{
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 M",
		dataPoints: dps[0]
	}]
});
 

var xValue;
var yValue;

<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		xValue = parseInt("${dataPoint.x}");
		yValue = parseFloat("${dataPoint.y}");
		
		dps[parseInt("${loop.index}")].push({
			x : xValue,
			y : yValue
		});	
		
	</c:forEach>	
</c:forEach> 

chart.render();

}

</script>
<body>
<p>[Course Name]</p>
<p>[Prof Name]</p>

<p>Upcoming Assignments for this class</p>
<table>
<tr>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
</tr>


</table>

<div id="chartContainer" style="height: 370px; width: 100%;"></div>
 <script type="text/javascript" src="<c:url value="/resources/js/lib/canvasjs.min.js" />"> </script>



</body>
</html>