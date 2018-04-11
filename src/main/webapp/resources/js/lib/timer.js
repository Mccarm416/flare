$(document).ready(function(){
	  
	(function(){
	  var counter = 5;

	  setInterval(function() {
	    counter--;
	    if (counter >= 0) {
	      span = document.getElementById("values");
	      span.innerHTML = counter;
	    }
	    // Display 'counter' wherever you want to display it.
	    if (counter === 0) {
	        alert('this is where it happens');
	        clearInterval(counter);
	    }
	    
	  }, 1000);
	    
	})();
	  
	})