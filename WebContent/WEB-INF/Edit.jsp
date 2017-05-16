<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Main layout-->
    
<main>
	
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
			
		    <!--Header-->
		    <div class="text-center">
		        <h3>Edit Profile</h3>
		        <hr class="mt-2 mb-2">
		    </div>
		    <!-- Body -->
			<form id="EditNameForm" action="edit" method="POST">
				    <div class="md-form">
			        <i class="fa fa-user prefix"></i>
			        <input type="text" id="name" class="form-control" name="name">
			        <label for="form3">New name</label>
				    </div>
				    
			        <div class="text-center">
			            <button class="btn blue darken-3">Update Name</button>
			            <hr>
			        </div>
			        <input type="hidden" id="action" name="action" value="name"/>
			</form>
			
		    <!-- Body -->
			<form id="EditPhotoForm" action="edit" method="POST" enctype="multipart/form-data">
				    <div class="md-form">
			        <i class="fa fa-file-photo-o prefix" aria-hidden="true"></i>
			        <input type="file" id="profilephoto" accept="image/jpeg" class="form-control" name="profilephoto">
			        </div>
				    
			        <div class="text-center">
			            <button class="btn blue darken-3">Update Photo</button>
			            <hr>
			        </div>
			        <input type="hidden" id="action" name="action" value="pic"/>
			</form>
			
			
		    <!-- Body -->
			<form id="EditPasswordForm" action="edit" method="POST" >
				    <div class="md-form">
				    <i class="fa fa-lock prefix"></i>
			        <input type="password" id="new_password" class="form-control" name="new_password">
			        <label for="form4">New Password</label>
			        </div>
				    
				    <div class="md-form">
				    <i class="fa fa-lock prefix"></i>
			        <input type="password" id="confirm_password" class="form-control" name="confirm_password">
			        <label for="form5">Confirm Password</label>
			        </div>
				    
			        <div class="text-center">
			            <button class="btn blue darken-3">Update Password</button>
			            <hr>
			        </div>
			        <input type="hidden" id="action" name="action" value="password"/>
				
			</form>
	</div>

</main>


<!--  -->
<script>
var new_password = document.getElementById("new_password"), confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(new_password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

new_password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>

