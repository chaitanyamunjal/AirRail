<!--Main layout-->
    
<main>
	
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
	        
		<!--Form with header-->
		<div class="card">
		    <div class="card-block">
			
			        <!--Header-->
			        <div class="form-header blue darken-3">
			            <h3><i class="fa fa-lock"></i> Login:</h3>
			        </div>
			
			        <!--Body-->
			        <form id="loginForm">
			                <div class="md-form">
					            <i class="fa fa-user prefix"></i>
					            <input type="text" id="username"  class="form-control" name="username" required/>
					            <label for="form3">Username</label>
					        </div>
					
					        <div class="md-form">
					            <i class="fa fa-lock prefix"></i>
					            <input type="password" id="password" class="form-control" name="password" required/>
					            <label for="form4">Your password</label>
					        </div>
					
					        <div class="text-center">
					            <button class="btn blue darken-3" type="button" id="login">Login</button>
					        </div>
						
					        <input type="hidden" value="login" name="action" />
					 </form>
					 <h5 class="text-danger text-center" id="invalid"></h5>
			    </div>
			
			    <!--Footer-->
			    <div class="modal-footer">
			        <div class="options">
			            <p>Not a member? <a href="signup">Sign Up</a></p>
			            <p>Forgot <a href="#">Password?</a></p>
			        </div>
			    </div>
			
			</div>
			<!--/Form with header-->
		</div>
</main>
    <!--/Main layout-->
    