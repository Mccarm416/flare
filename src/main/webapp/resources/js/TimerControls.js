var timer = new Timer();

var setting = 0;


var secs;
var mins;
var hrs;

var ctHrs;
var ctMins;
var ctHrs;

function convertToSeconds(formData){
	
	
	return secs
}



$('.targetTime').click(function () {
	
	var countDown = formData;
	
	
});


// Start button
$('#timeBox .startButton').click(function () {
		
		var hrs = getUrlParameter('hrs')
		var mins = getUrlParameter('mns')
		var secs = getUrlParameter('sec')

		var ctMin = parseInt(mins);
		var ctHour = parseInt(hrs);
		var ctSecs = parseInt(secs);

		
		
	 timer.start({countdown: true, startValues: {hours:ctHour, minutes:ctMin,seconds: ctSecs}});
	 $('#timeBox .values').html(timer.getTimeValues().toString());
	 
		
	 
	 
	
	
	
});


$




// Pause button
$('#timeBox .pauseButton').click(function () {
    timer.pause();
});

// Pauses and sets timer/counter to zero.
$('#timeBox .stopButton').click(function () {
	
	timer.reset();
    timer.stop();
    
});

//Resets timer/counter to zero
$('#timeBox .resetButton').click(function () {
    timer.reset();
});


// Event listeners 

timer.addEventListener('secondTenthsUpdated', function (e) {
	$('#timeBox .values').html(timer.getTimeValues().toString(['hours', 'minutes', 'seconds', 'secondTenths'])
			
	
	
	);
});
timer.addEventListener('started', function (e) {
    $('#timeBox .values').html(timer.getTimeValues().toString());
});
timer.addEventListener('reset', function (e) {
    $('#timeBox .values').html(timer.getTimeValues().toString());
});



// Count down functions

// Activates when timer reaches 0

timer.addEventListener('targetAchieved', function (e) {
	
    $('#timeBox .values').html('Studying Done!');
    
    var hrs = getUrlParameter('hrs')
	var mins = getUrlParameter('mns')
	var secs = getUrlParameter('sec')

	
	  
	$.ajax({
		  type: "POST",
		  url: "/time",
		  data: { hours: hrs, minutes:mins, seconds: secs, }
		}).done(function( msg ) {
		  alert( msg );
		  //do other processing
		});
	
    
    ('#recordedTimes').append($('<option>', {
        value: hrs+":"+mins+":"+secs,
        text: hrs+":"+mins+":"+secs
    }));
    
    
});


	


// Collects entered GET parameter 

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};