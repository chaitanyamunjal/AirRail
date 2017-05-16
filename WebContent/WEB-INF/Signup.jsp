
<!--
Form with header
Sign Up Form
-->

<!--Main layout-->
    
<main>
	
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
	
			        
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3><i class="fa fa-user"></i> Register:</h3>
		        </div>
		
		        <!--Body-->
		        <form id="SignupForm">
			        <div class="md-form">
			            <i class="fa fa-user prefix"></i>
			            <input type="text" id="name" class="form-control" name="name" required/>
			            <label for="form3">Your name</label>
			        </div>
			        <div class="md-form">
			            <i class="fa fa-user prefix"></i>
			            <input type="text" id="username"  class="form-control" name="username" required/>
			            <label for="form3">Username</label>
			        </div>
			        <div class="md-form">
			            <i class="fa fa-envelope prefix"></i>
			            <input type="email" id="email" class="form-control" name="email" required/>
			            <label for="form2">Your email</label>
			        </div>
			
			        <div class="md-form">
			            <i class="fa fa-lock prefix"></i>
			            <input type="password" id="password" class="form-control" name="password" required/>
			            <label for="form4">Your password</label>
			        </div>
			
			        <div class="text-center">
			            <button class="btn blue darken-3" type="button" id="signup">Sign up</button>
			            
			            <!-- Displaying the Invalid message if username already exists -->
					 	<h5 class="text-danger text-center" id="invalid"></h5>
			            
			            <hr>
			            <fieldset class="form-group">
			                <input type="checkbox" id="checkbox1">
			                <label for="checkbox1">Subscribe me to the newsletter</label>
			            </fieldset>
			        </div>
				</form>
		    </div>
		</div>
		<!--/Form with header-->
	</div>
</main>