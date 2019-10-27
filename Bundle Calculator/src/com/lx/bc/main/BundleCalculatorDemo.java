/**
 *  @ClassName BundleCalculatorDemo
 *  @Description Define Demo Class for Bundle Calculator.
 *  @author Liu Xia
 *  @Date 2019/10/27
 *  @Version 1.0
 */
package com.lx.bc.main;

import java.util.List;
import com.lx.bc.model.Order;
import com.lx.bc.model.Output;
import com.lx.bc.model.Submission;
import com.lx.bc.service.BundleCalculatorService;

public class BundleCalculatorDemo {
	
	private static List<Submission> submissions;
	private static List<Order> orders;
	private static List<Output> outputs;
	
	public static void main(String[] args) {
		//prepare the submissions based on submission format file		
		submissions = BundleCalculatorService.loadSubmissionFormats();
		
		//prepare the orders based on Orders.txt file
		orders = BundleCalculatorService.loadOrders();
		outputs = BundleCalculatorService.bundleCalculator(submissions, orders);
		BundleCalculatorService.printOutputsToFile(outputs);
	}



}
