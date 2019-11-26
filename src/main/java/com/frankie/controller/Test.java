package com.frankie.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Test {
	
	final static Logger logger=Logger.getLogger(Test.class);
	public static void main(String[] args) {
		System.out.println("Debug application");
		System.out.println("Info application");
		System.out.println("Warn application");
		System.out.println("Error application");
		System.out.println("Fatal application");
		
		logger.debug("debug application");
		logger.info("information");
		logger.warn("warn");
		logger.error("error occured");
		logger.fatal("fatal occured");
		
	}

}
