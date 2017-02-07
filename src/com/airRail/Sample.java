package com.airRail;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON) 

public class Sample {

	@GET
	public double calculate(){
		// Load from 'FCL' file
		String fileName = "FCL/Sample.fcl";
		FIS fis = FIS.load(fileName, true); // FUZZY INFERENCE SYSTEM

		// Error while loading?
		if (fis == null) {
			System.err.println("Can't load file: '" + fileName + "'");
			return 0;
		}

		FunctionBlock functionBlock = fis.getFunctionBlock("calculate");
		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Set inputs
		fis.setVariable("directFlight", 1);
		fis.setVariable("distance", 25);
		fis.setVariable("costDifference", 1000);
		fis.setVariable("totalTravelTime", 5);
		fis.setVariable("superFastTrains", 11);
		fis.setVariable("scheduleAlignment", 9);

		// Evaluate
		fis.evaluate();

		// Show output variable's chart
		Variable rfci = functionBlock.getVariable("rfci");
		JFuzzyChart.get().chart(rfci, rfci.getDefuzzifier(), true);
		
		
		// print the output variable
		System.out.println("Output is = " + fis.getVariable("rfci").getValue());

		// Print ruleSet
		System.out.println(fis);

		// Show each rule (and degree of support)
		for (Rule r : fis.getFunctionBlock("calculate").getFuzzyRuleBlock("No1")
				.getRules())
			System.out.println(r);
		
		return fis.getVariable("rfci").getValue();
	}
}
