<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main layout-->
    
<main>
	<!-- Nav tabs -->
	<div class="tabs-wrapper"> 
	    <ul class="nav classic-tabs darker blue darken-3" role="tablist">
	        <li class="nav-item">
	            <a class="nav-link waves-light active" data-toggle="tab" href="#panel51" role="tab">Impedance Factors</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link waves-light" data-toggle="tab" href="#panel52" role="tab">Attraction Factors</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link waves-light" data-toggle="tab" href="#panel53" role="tab">Rail API</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link waves-light" data-toggle="tab" href="#panel54" role="tab">Google Maps</a>
	        </li>
	    </ul>
	</div>

	<!-- Tab panels -->
	<div class="tab-content card">
	
	
	
	
	    <!-- START Panel 1-->
	    <div class="tab-pane fade in show active" id="panel51" role="tabpanel">
			<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				<!--Naked Form-->
				<div class="card-block">
				    <!--Header-->
				    <div class="text-center">
				        <h3>Impedance Factors</h3>
				        <hr class="mt-2 mb-2">
				    </div>
				    <br>
				    <!--Body-->
				    <form id="ImpedanceForm" action="home" method="POST">
							    <div class="md-form">
							        <i class="fa fa-plane prefix"></i>
							        <input type="number" id="directFlights" class="form-control" name="directFlights" required/>
							        <label for="form3">Direct Flights</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-road prefix"></i>
							        <input type="number" id="distance" class="form-control"  name="distance" required/>
							        <label for="form2">Distance</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-rupee prefix" aria-hidden="true"></i>
							        <input type="number" id="costDifference" class="form-control" name="costDifference" required/>
							        <label for="form34">Cost Difference</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-calendar prefix"></i>
							        <input type="number" id="totalTravelTime" class="md-textarea" name="totalTravelTime" required/>
							        <label for="form8">Total Travel Time</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-train prefix"></i>
							        <input type="number" id="superFastTrains" class="md-textarea" name="superFastTrains" required/>
							        <label for="form8">Super Fast Trains</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-send prefix"></i>
							        <input type="number" id="scheduleAlignment" class="md-textarea" name="scheduleAlignment" required/>
							        <label for="form8">Schedule Alignment</label>
							    </div>
							    <div class="text-center">
							        <button class="btn blue darken-3" type="button" id="impedanceSubmit">Submit</button>
							    </div>
							    <input type="hidden" name="action" id="action" value="impedance"/>
						</form>
					<br>
				</div>
				<!--Naked Form-->
			</div>
			<!-- Displaying the AJAX Response of RFCI From the HomeServlet -->
	    <div>
	    	<h4 class="text-danger text-center">RFCI :-</h4>
	    	<h5 id="rfciImpedance" class="text-danger text-center"></h5>
	    </div>
	    </div>
	    <!--/. END  Panel 1-->
	
	
	
	   <!-- START Panel 2-->
	   
	   
	    <div class="tab-pane fade" id="panel52" role="tabpanel">
			<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				<!--Naked Form-->
				<div class="card-block">
				    <!--Header-->
				    <div class="text-center">
				        <h3>Attraction Factors</h3>
				        <hr class="mt-2 mb-2">
				    </div>
				    <br>
				    <!--Body-->
				    <form id="AttractionForm" action="home" method="POST">
							    <div class="md-form">
							        <i class="fa fa-rupee prefix" aria-hidden="true"></i>
							        <input type="number" id="PerCapitaIncome" class="form-control" name="PerCapitaIncome" required/>
							        <label for="form3">PerCapitaIncome</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-male prefix" aria-hidden="true"></i>
							        <input type="number" id="Population" class="form-control"  name="Population" required/>
							        <label for="form2">Population</label>
							    </div>
							    <div class="md-form">
							    	<i class="fa fa-home prefix" aria-hidden="true"></i>
							        <input type="number" id="CityType" class="form-control" name="CityType" required/>
							        <label for="form34">CityType</label>
							    </div>
							    <div class="md-form">
							    	<i class="fa fa-dot-circle-o prefix" aria-hidden="true"></i>
							        <input type="number" id="CatchmentArea" class="md-textarea" name="CatchmentArea" required/>
							        <label for="form8">CatchmentArea</label>
							    </div>
							    <div class="md-form">
							    	<i class="fa fa-balance-scale prefix"></i>
							        <input type="number" id="NicheAttributes" class="md-textarea" name="NicheAttributes" required/>
							        <label for="form8">NicheAttributes</label>
							    </div>
							    <div class="text-center">
							        <button class="btn blue darken-3" type="button" id="attractionSubmit">Submit</button>
							    </div>
							    <input type="hidden" name="action" id="action" value="attraction"/>
						</form>
					<br>	
				</div>
				<!--Naked Form-->
			</div>
			    <div>
			    	<h4 class="text-danger text-center">RFCI :-</h4>
			    	<h5 id="rfciAttraction" class="text-danger text-center"></h5>
			    </div>
	    </div>
	    
	    <!--/. END Panel 2-->
	
	
	
	
		<!--  START Panel 3-->
	
	
	    <div class="tab-pane fade" id="panel53" role="tabpanel">
			<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				<!--Naked Form-->
				<div class="card-block">
				    <!--Header-->
				    <div class="text-center">
				        <h3>Railway Data</h3>
				        <hr class="mt-2 mb-2">
				    </div>
				    <br>
				    <!--Body-->
				    <form id="RailwayForm" action="home" method="POST">
							    <div class="md-form">
							        <i class="fa fa-mail-forward prefix" aria-hidden="true"></i>
							        <input type="text" id="from" class="form-control" name="from" required/>
							        <label for="form3">From</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-mail-reply prefix" aria-hidden="true"></i>
							        <input type="text" id="to" class="form-control"  name="to" required/>
							        <label for="form2">To</label>
							    </div>
							    
							    <div class="md-form">
							    	<i class="fa fa-calendar prefix" aria-hidden="true"></i>
							        <input type="date" id="date" class="form-control"  name="date"  required/>
							    </div>
							    <div class="text-center">
							        <button class="btn blue darken-3">Submit</button>
							    </div>
							    <input type="hidden" name="action" id="action" value="railway"/>
						</form>
					<br>	
				</div>
				<!--Naked Form-->
			</div>
	    </div>
	    <!--/. END Panel 3-->
	
	
	
	  	<!-- START Panel 4-->
	    
	    
	    <div class="tab-pane fade" id="panel54" role="tabpanel">
			<div class="col-md-6 offset-md-3" style="padding-top: 30px">
				<!--Naked Form-->
				<div class="card-block">
				    <!--Header-->
				    <div class="text-center">
				        <h3>Google Maps</h3>
				        <hr class="mt-2 mb-2">
				    </div>
				    <br>
				    <!--Body-->
				    <form id="googleForm" action="home" method="POST">
							    <div class="md-form">
							        <i class="fa fa-mail-forward prefix" aria-hidden="true"></i>
							        <input type="text" id="from1" class="form-control" name="from1" required/>
							        <label for="form3">From</label>
							    </div>
							    <div class="md-form">
							        <i class="fa fa-mail-reply prefix" aria-hidden="true"></i>
							        <input type="text" id="to1" class="form-control"  name="to1" required/>
							        <label for="form2">To</label>
							    </div>
							    <div class="text-center">
							        <button class="btn blue darken-3" type="button" id="googleSubmit">Submit</button>
							    </div>
							    <input type="hidden" name="action" id="action" value="google"/>
						</form>
					<br>	
				</div>
				<!--Naked Form-->
			</div>
			<div>
		    	<h4 class="text-danger text-center">Via :-</h4>
		    	<h5 id="via" class="text-danger text-center"></h5>
		    </div>
	    </div>
	    
	    <!--/. end Panel 4-->
	    
	</div>
</main>