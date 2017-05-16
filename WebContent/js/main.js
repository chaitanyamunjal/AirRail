// alert('loaded');

// setInterval(reloadPage, 5000);


function reloadPage() {
	console.log("ASDASD");
	// window.location.reload();
};


$(document).ready(function() {
    $('.mdb-select').material_select();
  });



$(document).ready(function(){
    
	$("#impedanceSubmit").click(function(){
    
		// Impedance Factors --->>>  creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
    		directFlights :$("#directFlights").val(),
    		distance: $("#distance").val(),
    		costDifference :$("#costDifference").val(),
    		totalTravelTime : $("#totalTravelTime").val(),
    		superFastTrains :$("#superFastTrains").val(),
    		scheduleAlignment : $("#scheduleAlignment").val(),
    		action: "impedance"
    	};
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data1, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#rfciImpedance").html(data1.data);
        });
    	
	});
	
	$("#attractionSubmit").click(function(){
    	// Attraction Factors -->> creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
			PerCapitaIncome :$("#PerCapitaIncome").val(),
			Population: $("#Population").val(),
			CityType :$("#CityType").val(),
			CatchmentArea : $("#CatchmentArea").val(),
    		NicheAttributes : $("#NicheAttributes").val(),
    		action: "attraction"
    	};
		
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data5, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#rfciAttraction").html(data5.data);
        });
    	
	});
	
	$("#googleSubmit").click(function(){
    	
    	// google maps --> creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
    		from :$("#from1").val(),
    		to :$("#to1").val(),
    		action: "google"
    	};
		
		// sending a POST AJAX request to Home Servlet
    	$.post("home",data,
    		 function(data3, status){                  // callback function which runs on receiving a response from the Home Servlet
        	 $("#via").html(data3.data);
        });
    });
	
});


// Function for Login AJAX Request to Login servlet

$(document).ready(function(){

		$("#login").click(function(){
			var data = {
					username :$("#username").val(),
					password :$("#password").val()
				};
			
			// sending a POST AJAX request to Home Servlet
			$.ajax({
				url : "login",
				data: data, 
				type: "post",
				success: function(data) {
			    	window.location.href="home";
			    },
				error: function(XMLHttpRequest, textStatus, errorThrown) {	
			    	$("#invalid").html("Invalid Username or Password.");
			    }
		
			});

		});
});




//Function for SignUp AJAX Request to SignUp Servlet

$(document).ready(function(){

		$("#signup").click(function(){
			var data = {
					username :$("#username").val(),
					password :$("#password").val(),
					name :$("#name").val(),
					email :$("#email").val()
				};
			
			// sending a POST AJAX request to Home Servlet
			$.ajax({
				url : "signup",
				data: data, 
				type: "post",
				success: function(data) {
					alert('Congrats! Account created Successfully.');
			    	window.location.href="login";
			    },
				error: function(XMLHttpRequest, textStatus, errorThrown) {	
			    	$("#invalid").html("Try Again! Username already exists.");
			    }
		
			});

		});
});




//----------------------- Main Page ----------------------------------//
$(document).ready(function(){

	$('.datepicker').pickadate();
	
	$("#mainSubmit").click(function(){
		
			// getting the date from the Form and then converting it into yyyy-mm-dd format
			var d = new Date($("#date").val()),
		        month = '' + (d.getMonth() + 1),
		        day = '' + d.getDate(),
		        year = d.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;

		    var date = [year, month, day].join('-');         //  yyyy-mm-dd
		    var date1 = [day , month].join('-');             //  dd-mm
		// google maps --> creating a JS variable with JSON data to be sent as an AJAX request
		var data = {
			from :$("#from").val(),
			to :$("#to").val(),
			date : date,
			date1 : date1,
			action: "main"
		};
		
		// sending a POST AJAX request to Main Servlet
		$.post("main",data,
			 function(bothJson, status){                  // callback function which runs on receiving a response from the Home Servlet
			
			// STEP 1 -> FLIGHTS DATA
			var data1 = bothJson[0];
			var airlines = [];
			var flight_number = [];
			var arrives_at = [];
			var origin = [];
			var destination = [];
			var departs_at = [];
			var price = [];
			
			for(var i=0;i<data1.results.length;i++){
					airlines[i] = destination[i] = data1.results[i].itineraries[0].outbound.flights[0].operating_airline;
					flight_number[i] = destination[i] = data1.results[i].itineraries[0].outbound.flights[0].flight_number;
					price[i] = destination[i] = data1.results[i].fare.total_price;
					departs_at[i] = data1.results[i].itineraries[0].outbound.flights[0].departs_at;
					arrives_at[i] = data1.results[i].itineraries[0].outbound.flights[0].arrives_at;
					origin[i] = data1.results[i].itineraries[0].outbound.flights[0].origin.airport;
					destination[i] = data1.results[i].itineraries[0].outbound.flights[0].destination.airport;
					
				}
			

			var tr = document.createElement("tr");
		    
			var t1= document.createElement("th");
		    t1.innerHTML = "Airlines"; 
		    tr.appendChild(t1);
		    
		    var t2= document.createElement("th");
		    t2.innerHTML = "Flight Number"; 
		    tr.appendChild(t2);

			var t3= document.createElement("th");
		    t3.innerHTML = "Origin"; 
		    tr.appendChild(t3);

		    var t4= document.createElement("th");
		    t4.innerHTML = "Destination";
		    tr.appendChild(t4);

		    var t5= document.createElement("th");
		    t5.innerHTML = "Departure Time";
		    tr.appendChild(t5);

		    var t6= document.createElement("th");
		    t6.innerHTML = "Arrival Time";
		    tr.appendChild(t6);
			
		    var t7= document.createElement("th");
		    t7.innerHTML = "Price";
		    tr.appendChild(t7);
		    flights_table.appendChild(tr);

		    for(var j=0;j<data1.results.length;j++){

					var tr = document.createElement("tr");
				    
					var t1= document.createElement("td");
				    t1.innerHTML = airlines[j]; // adding data to TD
				    tr.appendChild(t1);
	
					var t2= document.createElement("td");
				    t2.innerHTML = flight_number[j]; 
				    tr.appendChild(t2);
	
					var t3= document.createElement("td");
				    t3.innerHTML = origin[j]; 
				    tr.appendChild(t3);

				    var t4= document.createElement("td");
				    t4.innerHTML = destination[j];
				    tr.appendChild(t4);

				    var t5= document.createElement("td");
				    t5.innerHTML = departs_at[j];
				    tr.appendChild(t5);

				    var t6= document.createElement("td");
				    t6.innerHTML = arrives_at[j];
				    tr.appendChild(t6);
					
				    var t7= document.createElement("td");
				    t7.innerHTML = price[j];
				    tr.appendChild(t7);
				    
				    flights_table.appendChild(tr);
					
			}
		    
			// STEP 2 -> TRAIN DATA
			 	var data2 = bothJson[1];
			 	console.log(data2);
			 	var name = [];
				var train_number = [];
				var from = [];
				var to = [];
				var travel_time = [];
				var departs_at = [];
				var arrives_at = [];
				var price = [];
				
				
				for(var i=0;i<data2.train.length;i++){
					name[i] = data2.train[i].name;
					train_number[i] = data2.train[i].number;
					from[i] = data2.train[i].from.code;
					to[i] = data2.train[i].to.code;
					travel_time[i] = data2.train[i].travel_time;
					departs_at[i] = data2.train[i].src_departure_time;
					arrives_at[i] = data2.train[i].dest_arrival_time;
					price[i] = data2.train[i].no;
				}
			
			
				var tr = document.createElement("tr");
			    var t1= document.createElement("th");
			    t1.innerHTML = "Name"; 
			    tr.appendChild(t1);
			    
			    var t2= document.createElement("th");
			    t2.innerHTML = "Train Number"; 
			    tr.appendChild(t2);

				var t3= document.createElement("th");
			    t3.innerHTML = "From"; 
			    tr.appendChild(t3);

			    var t4= document.createElement("th");
			    t4.innerHTML = "To";
			    tr.appendChild(t4);

			    var t5= document.createElement("th");
			    t5.innerHTML = "Travel Time";
			    tr.appendChild(t5);

			    var t6= document.createElement("th");
			    t6.innerHTML = "Departure Time";
			    tr.appendChild(t6);
				
			    var t7= document.createElement("th");
			    t7.innerHTML = "Arrival Time";
			    tr.appendChild(t7);
			    
			    var t8= document.createElement("th");
			    t8.innerHTML = "Price";
			    tr.appendChild(t8);
			
			    trains_table.appendChild(tr);
			    
			    for(var j=0;j<data2.train.length;j++){

					var tr = document.createElement("tr");
				    
					var t1= document.createElement("td");
				    t1.innerHTML = name[j]; // adding data to TD
				    tr.appendChild(t1);
	
					var t2= document.createElement("td");
				    t2.innerHTML = train_number[j]; 
				    tr.appendChild(t2);
	
					var t3= document.createElement("td");
				    t3.innerHTML = from[j]; 
				    tr.appendChild(t3);

				    var t4= document.createElement("td");
				    t4.innerHTML = to[j];
				    tr.appendChild(t4);

				    var t5= document.createElement("td");
				    t5.innerHTML = travel_time[j];
				    tr.appendChild(t5);

				    var t6= document.createElement("td");
				    t6.innerHTML = departs_at[j];
				    tr.appendChild(t6);
					
				    var t7= document.createElement("td");
				    t7.innerHTML = arrives_at[j];
				    tr.appendChild(t7);
				    

				    var t8= document.createElement("td");
				    t8.innerHTML = price[j];
				    tr.appendChild(t8);
				    
				    trains_table.appendChild(tr);
					
			}
			
	    });
	});

});