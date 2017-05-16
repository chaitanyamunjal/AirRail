<!--
Contact Form
-->
<!--Main layout-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<main>
	
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
		
		<c:if test="${submission_status == '1'}">
			<div class="text-success text-center">Your Message has been Successfully submitted.</div>	        
		</c:if>
		
		<c:if test="${submission_status == '2'}">
			<div class="text-danger text-center">Please Fill all the fields of the Form.</div>	        
		</c:if>
		
		<div class="card-block">
		
		    <!--Header-->
		    <div class="text-center">
		        <h3><i class="fa fa-envelope"></i> Write to us:</h3>
		        <hr class="mt-2 mb-2">
		    </div>
		
		    <!--Body-->
		    <br>
			<!--Body-->
		    <form id="ContactForm" action="contact" method="POST">
				    <div class="md-form">
			        <i class="fa fa-user prefix"></i>
			        <input type="text" id="form3" class="form-control" name="name">
			        <label for="form3">Your name</label>
				    </div>
				
				    <div class="md-form">
				        <i class="fa fa-envelope prefix"></i>
				        <input type="text" id="form2" class="form-control" name="email">
				        <label for="form2">Your email</label>
				    </div>
				
				    <div class="md-form">
				        <i class="fa fa-tag prefix"></i>
				        <input type="text" id="form32" class="form-control" name="subject">
				        <label for="form34">Subject</label>
				    </div>
				
				    <div class="md-form">
				        <i class="fa fa-pencil prefix"></i>
				        <textarea type="text" id="form8" class="md-textarea" name="message"></textarea>
				        <label for="form8">Message</label>
				    </div>
				
				    <div class="text-center">
				        <button class="btn btn-default">Submit</button>
				
				        <div class="call">
				            <br>
				            <p>Or would you prefer to call?
				            <br>
				            <span><i class="fa fa-phone"> </i></span>+91 9003681378</p>
				        </div>
				    </div>
			</form>
		</div>
		<!--Naked Form-->
	</div>
</main>