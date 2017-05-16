
<main>
	<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				
		<div class="card">
		    <div class="card-block">
		
		        <!--Header-->
		        <div class="color-amadeus form-header ">
		            <h3>Enter Details</h3>
		        </div>
		        <!--Body-->
		        <form id="MainForm">
			        <div class="md-form">
			            <select class="mdb-select" id="from" name="from">
								<option value="Delhi">Delhi</option>
								<option value="Chennai">Chennai</option>
								<option value="Mumbai">Mumbai</option>
								<option value="Bengaluru">Bengaluru</option>
								<option value="Kolkata">Kolkata</option>
						</select>
						<label>From</label>
					 </div>
					<div class="md-form">
			       		<input type="text" id="to" class="form-control" name="to" required/>
						<label>To</label>
					 </div>
					 <div class="md-form">
    					<input placeholder="Selected date" type="date" name="date" id="date" class="form-control datepicker">
    					<label for="date-picker-example">Date</label>
					</div>
					 <div class="text-center">
			            <button class="btn blue darken-3" type="button" id="mainSubmit">Search</button>
			            <hr>
			        </div> 
			        <!-- Displaying the nearest Tier 1 city to the destination -->
				    <input type="hidden" name="action" id="action" value="main"/>   
				</form>
		    </div>
		</div>
		<br/><hr>
	</div>
		<div>
			<table class="table" id="flights_table">
			  <thead class="thead-inverse">
			    
			  </thead>
			  <tbody>
			  </tbody>
			</table>
		</div>
		
		
		<div>
			<table class="table" id="trains_table">
			  <thead class="thead-inverse">
			    
			  </thead>
			  <tbody>
			  </tbody>
			</table>
		</div>
</main>
				