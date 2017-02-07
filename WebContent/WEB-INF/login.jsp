<html>
<head>
	<title>Air Rail Connectivity</title>
	<link rel="shortcut icon" href="images/icon.png" type="image/png">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>	
<body onload="startTime(); errormsg();">
	<div class="container">

		<div class="header">
			<h2 id="heading">Air Rail Connectivity</h2>
			<h6 id="clock"></h6>
		</div>

		<div class="main">

			<div id="login_form">
				<form onsubmit="validate(event) && this.submit()" action="login" method="POST">
				<br><br>
				<b>Username : <input type="text" name="username" id="username" required/><br><br>
				Password : <input type="password" name="pass"id="pass" required/><br><br>
							<input type="submit" name="login" id="login" value="Login" />
							<input type="hidden" id="action" name="action" value="login"/>
				</b>
				</form>
			</div>	
			<div class="invalid" id="invalid"></div>
			<br><br>
			<div>
			<h4>New User ?</h4>
			
				<button onclick = "disp()" class="signup" id="signup1">Sign Up</button>
			
			</div>
			<div id="signup_form">
			<form action="login" method="POST">
				<b>
				Name :     <input type="text" name="name" id="name" required/><br><br>
				Username : <input type="text" name="user" id="user" required/><br><br>
				Password : <input type="password" name="password"id="password"  minlength=8 title="Minimum 8 Characters" required/><br><br>
							<input type="submit" name="signup" class="signup" value="Sign Up" />
							<input type="hidden" id="action" name="action" value="signup"/>
				</b>
			</form>
			
			</div>
		</div>
		


	</div>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script>

	$(function(){
		$(".main").show(500);
	});
	
	flag = "${flag}";
	console.log("flag is "+ flag);
</script>

<script type="text/javascript">
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}


function validate(e){

	e.preventDefault();
	var username = document.getElementById('username').value;
	var password = document.getElementById('pass').value;

	action.value = "login";
	
	return true;
}
		
	function disp() {
		$("#login_form").hide();
		$("#signup1").hide();
		$("#signup_form").show();
	}
	

	function errormsg(){
		
		if(flag == "5"){
			alert('The Username Already Exists. Please try again.');
		}
		else if(flag == "4")
			{
			alert('Account created successfully');
			
			}
	
	}

	
</script>
</body>
</html>