function classFinder() {
	
	// grab the input data
	var input = document.getElementById("classData").value;
	console.log("input is " + input);
	
	// if no input object
	if(input === null){
		console.log("Object is null, exiting func");
		return;
	}
	// if empty string
	else if(input == "" || input == " "){
		console.log("There is no input, the func will now terminate");
		return;
	}
	// begin reduction of entities
	else{
		let buildingFloor = input.substring(0,2);
		console.log("Building floor is: " + buildingFloor);
		switch(buildingFloor) {
			// Building List
			// B1
		    case "B1":
		    case "b1":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/B1.png";
		        break;
		        
		     // B2
		    case "B2":
		    case "b2":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/B2.png";
		        break;
		        
		     // B3
		    case "B3":
		    case "b3":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/B3.png";
		        break;

		     // B4
		    case "B4":
		    case "b4":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/B4.png";
		        break;
		        
		     // C1
		    case "C1":
		    case "c1":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/C1.png";
		        break;
		        
		        // C2
		    case "C2":
		    case "c2":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/C2.png";
		        break;
		        
		        // C3
		    case "C3":
		    case "c3":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/C3.png";
		        break;
		        
		        // C4
		    case "C4":
		    case "c4":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/C4.png";
		        break;
		        
		        // C5
		    case "C5":
		    case "c5":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/C5.png";
		        break;
		        
		        // D3
		    case "D3":
		    case "d3":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/D3.png";
		        break;
		        
		        // F1
		    case "F1":
		    case "f1":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/F1.png";
		        break;
		        
		        // F2
		    case "F2":
		    case "f2":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/F2.png";
		        break;
		        
		        // F3
		    case "F3":
		    case "f3":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/F3.png";
		        break;
		        
		        // F4
		    case "F4":
		    case "f4":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/F4.png";
		        break;
		        
		        // F5
		    case "F5":
		    case "f5":
		        console.log("Floor " + buildingFloor)
		        document.getElementById("imageContainer").src="resources/maps/F5.png";
		        break;
		        
		    default:
		       console.log("No Matches, func terminating")
		       return;
		}
	}
}