package com.codingchallenge;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WineTest {
	
	 private static final Logger logger = LogManager.getLogger(WineTest.class);  
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Wine w = new Wine("11YVCHAR001", 1000);
		w.setDescription("2011 Yarra Valley Chardonnay");
		w.setTankCode("T25-01");
		w.setProductState("Ready for bottling");
		w.setOwnerName("YV Wines Pty Ltd");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));
		
		
		printVarietyBreakdown(w);
		logger.info("Info: running application...");
	}

	private static void printVarietyBreakdown(Wine w) {
		// TODO: implement me
		logger.error("\n--------------- Sample List ---------------\n");
		logger.info(w.getComponents().toString());
	}


}
