<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Main layout-->
    
<main>

<div class="col-md-6 offset-md-3" style="padding-top: 30px">
	
<!--Rotating card-->
<div class="card-wrapper">
    <div id="card-1" class="card-rotating effect__click">

        <!--Front Side-->
        <div class="face front">

            <!-- Image-->
            <div class="card-up">
                <img src="images/background.png" class="img-fluid">
            </div>
            <!--Avatar-->
      
            <div class="avatar">
             <div class="view overlay hm-zoom rounded-circle">
					<a href="edit"><img src="images/${pic}" class="rounded-circle img-responsive profile ">
            		
				    </a>
		 	</div>
            </div>
            <!--Content-->
            <div class="card-block">
                <h4>${name}</h4>
                <!--Triggering button-->
                <a class="rotate-btn" data-card="card-1"><i class="fa fa-repeat"></i> Details</a>
            </div>
        </div>
        <!--/.Front Side-->

        <!--Back Side-->
        <div class="face back">

            <!--Content-->
            <h4>About me</h4>
            <table class="table">
				   <thead>
				       <tr>
				           <th>Name</th>
				           <th>Username</th>
				           <th>Email</th>
				           <th>Actions</th>
				       </tr>
				   </thead>
				   <tbody>
				       <tr>
				           <td>${name}</td>
				           <td>${un}</td>
				           <td>${email}</td>
				            <td>
				                <a class="teal-text" href="edit"><i class="fa fa-pencil prefix" title="Edit">Edit</i></a>
				                
				                <a class="red-text" href="edit"><i class="fa fa-question-circle prefix" aria-hidden="true" title="Reset Password">Reset Password </i></a>
				            </td>
				        </tr>
				
				    </tbody>
				</table>
			  <!--Triggering button-->
	           <a class="rotate-btn" data-card="card-1"><i class="fa fa-undo"></i> Back</a>
		</div>
		 <!--/.Back Side-->
	</div>
</div>
<!--/.Rotating card-->                        


</div>	
</main>