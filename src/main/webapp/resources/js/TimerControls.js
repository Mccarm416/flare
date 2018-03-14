var timer = new Timer();
timer.start({precision: 'secondTenths'});
$('#timeBox .startButton').click(function () {
	 timer.start({precision: 'secondTenths'});
   
});
$('#timeBox .pauseButton').click(function () {
    timer.pause();
});
$('#timeBox .stopButton').click(function () {
    timer.stop();
});
$('#timeBox .resetButton').click(function () {
    timer.reset();
});
timer.addEventListener('secondTenthsUpdated', function (e) {
	$('#timeBox .values').html(timer.getTimeValues().toString(['hours', 'minutes', 'seconds', 'secondTenths']));
});
timer.addEventListener('started', function (e) {
    $('#timeBox .values').html(timer.getTimeValues().toString());
});
timer.addEventListener('reset', function (e) {
    $('#timeBox .values').html(timer.getTimeValues().toString());
});