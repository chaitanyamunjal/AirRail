<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Air Rail Connectivity</title>
<link rel="shortcut icon" href="images/favicon1.png" type="image/png">
<link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body onload="startTime();">

	<div class="container">

		<div class="header">
			<h2 id="heading">Air Rail Connectivity</h2>
			<form action="logout">
				<input class="btn btn-success" type="submit" id="logout"
					title="Logout" value="Log out" />
			</form>
			<h6 id="clock"></h6>
		</div>

		<div class="sidenav">
			<ul id="ulside">
				<li><a>${un}</a></li>
				<li><a href="http://localhost:8080/AirRailConnectivity/home">Manage
						Bookings</a></li>
			</ul>
		</div>
		<div style="text-align: center">
			<p>
				<b>Welcome ${name}!!</b>
			</p>
		</div>

		<div class="main">
		
			<form id="input_form" action="home" method="POST">
			<br>
					Direct Flights : <input type="number" name="directFlights" id="directFlights" required/><br>
					Distance : <input type="number" name="distance" id="distance" required/><br>
					Cost Difference: <input type="number" name="costDifference" id="costDifference" required/><br>
					Total Travel Time : <input type="number" name="totalTravelTime" id="totalTravelTime" required/><br>
					Super Fast Trains :<input type="number" name="superFastTrains" id="superFastTrains" required/><br>
					Schedule Alignment : <input type="number" name="scheduleAlignment" id="scheduleAlignment" required/><br>
					<input type="submit" class="search" value="Submit"/>
			</form>


		</div>

	</div>

	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script>
		$(function() {

			$(".details").click(function() {
				$(".details").animate({
					top : '400px'
				}).animate({
					top : '10px'
				});
			});

			$("#back_button").click(function() {

				$("#trip").show();
				$(".details").show();
				$("#back").hide();
			});

		});

		function showNext() {
			$("#trip").show();
			$("#booking").hide();
			$("#back").show();
			$(".details").hide();
			$("#search_form").hide();

		};

		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
			var t = setTimeout(startTime, 500);
		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i
			}
			; // add zero in front of numbers < 10
			return i;
		}

		function validate(event) {
			//event.preventDefault();
			var today = new Date();
			today.setHours(0,0,0,0);          // it is set to 0 so that the comparison of dates is not made based on hours
			var d_date = document.getElementById("d_date").value;
			d_date = new Date(d_date);
			d_date.setHours(0,0,0,0); // it is set to 0 so that the comparison of dates is not made based on hours
			var r_date = document.getElementById("r_date").value;
			r_date = new Date(r_date);

			var from = document.getElementById("from").value;
			var to = document.getElementById("to").value;
			
			
			if (from === to) {                                 // checking for same city
				alert('Please enter different cities.');
				return false;
			} else if (d_date < today || r_date < d_date) {   // checking for valid dates
				alert('Invaid date.Try again!');
				return false;
			} else {
				print(from, to, d_date, r_date);
			}

		}

		$("#search_form").submit(function(e) {
			var validationFailed = validate(e);
			// do your validation here ...
			if (!validationFailed) {
				e.preventDefault();
				return false;
			}
		});

		function print(from, to, d_date, r_date) {

			var tr = document.createElement("tr");
			var t1 = document.createElement("td");
			t1.innerHTML = from; // adding data to TD
			tr.appendChild(t1);

			var t2 = document.createElement("td");
			t2.innerHTML = to;
			tr.appendChild(t2);

			var t3 = document.createElement("td");
			// d_date.toLocaleDateString("en-US");
			t3.innerHTML = d_date.toLocaleDateString("en-US");
			tr.appendChild(t3);

			var t4 = document.createElement("td");
			t4.innerHTML = r_date.toLocaleDateString("en-US");
			tr.appendChild(t4);

			trip_table.appendChild(tr);

		}

		function show_footer() {

			$("#flights_submit")
					.click(
							function() {
								$(".footer").show();
								$(".details").hide();
								var selected_flight = document
										.querySelector("input[name='optradio']:checked").value;
								console.log(selected_flight);
								$(".inside_footer")
										.html(
												document
														.getElementById(selected_flight).innerHTML);

								$(".inside_footer").find("input").remove();
								$("#book").show();
							});
		}

		function display_footer(event) {
			event.preventDefault();
			show_footer();
		}

		// to give default date value to departure date and return date as current date in the HTML Form
		function default_date() {

			// getting todays date
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; // bcoz january is 0
			var yyyy = today.getFullYear();

			if (dd < 10) {
				dd = '0' + dd;
			}
			if (mm < 10) {
				mm = '0' + mm;
			}
			var today = yyyy + '-' + mm + '-' + dd;
			document.getElementById("d_date").defaultValue = today;

			// getting tomorrows date
			var tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
			var d = tomorrow.getDate();
			var m = tomorrow.getMonth() + 1; // bcoz january is 0
			var y = tomorrow.getFullYear();

			if (d < 10) {
				d = '0' + d;
			}
			if (m < 10) {
				m = '0' + m;
			}
			var tomorrow = y + '-' + m + '-' + d;
			document.getElementById("r_date").defaultValue = tomorrow;

		}

		default_date(); // calling the function so that the default value is assigned to the fields

		function deleteBooking(bookingId) {
			entryToDelete.value = bookingId;
			deleteForm.submit();
		}

	</script>

</body>
</html>