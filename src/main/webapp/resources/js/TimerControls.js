var timer = new Timer();

var setting = 0


// Start button
$('#timeBox .startButton').click(function () {
	
	
	
	if(Boolean(setting)){
	
	// if set to stopwatch (true = 1)
	
		
	 timer.start({precision: 'secondTenths'});
	 
	}else{
	 
	 // if timer is set to count down (false = 0)
	 
		timer.stop();
	 timer.start({countdown: true, startValues: {seconds: 30}});
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
    $('#timeBox .values').html('KABOOM!!');
});
