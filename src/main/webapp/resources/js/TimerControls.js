var timer = new Timer();

var setting = 0;






function convertToSeconds(formData){
	
	
	return secs
}


$('.targetTime').click(function () {
	
	var countDown = formData;
	
	
	
});


// Start button
$('#timeBox .startButton').click(function () {
	
	
	
	if(Boolean(setting)){
	
	// if set to stopwatch (true = 1)
	
		
	 timer.start({precision: 'secondTenths'});
	 
	}else{
	 
	 // if timer is set to count down (false = 0)
	 
		timer.stop();
		
		var hrs = getUrlParameter('hrs')
		var mins = getUrlParameter('mns')
		var secs = getUrlParameter('sec')

		var ctMin = parseInt(mins);
		var ctHour = parseInt(hrs);
		var ctSecs = parseInt(secs);

		
		
	 timer.start({countdown: true, startValues: {hours:ctHour, minutes:ctMin,seconds: ctSecs}});
	 $('#timeBox .values').html(timer.getTimeValues().toString());
	 
		
	 
	 
	}
	
	
});


$('#timeBox .switch').click(function(){
	
	if(setting == 1){
		
		
		setting = 0;
		timer.reset();
		timer.stop();
		
		
		
		
		
	}else if(setting == 0){
		
		
		setting = 1;
		timer.reset();
		timer.stop();
		
		
	}
})

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



// Countdown functions

// Activates when timer reaches 0
timer.addEventListener('targetAchieved', function (e) {
    $('#timeBox .values').html('Studying Done!');
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