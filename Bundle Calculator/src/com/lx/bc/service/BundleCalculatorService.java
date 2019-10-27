/**
 *  @ClassName BundleCalculatorService
 *  @Description Define Service class for Bundle Calculator project.
 *  @author Liu Xia
 *  @Date 2019/10/27
 *  @Version 1.0
 */
package com.lx.bc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lx.bc.model.Bundle;
import com.lx.bc.model.Order;
import com.lx.bc.model.Output;
import com.lx.bc.model.Submission;

public class BundleCalculatorService {

	public static List<Order> loadOrders() {
		List<Order> orders = new ArrayList<Order>();
		File file = new File("./src/Orders.txt");
		BufferedReader br;
		String st;
		StringBuffer ordersSb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				if(!st.contains("`")) {
					ordersSb = ordersSb.append(st+",");
				}
			}
			String[] ordersArr = (ordersSb.toString().substring(0, ordersSb.toString().length()-1)).split(",");
			for(String orderStr:ordersArr) {
				Order order = new Order(Integer.valueOf(orderStr.split(" ")[0]), orderStr.split(" ")[1]);
				orders.add(order);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public static List<Submission> loadSubmissionFormats() {
		List<Submission> submissions = new ArrayList<Submission>();
		File file = new File("./src/SubmissionFormats.txt");
		BufferedReader br;
		String st;
		int i=0;
		StringBuffer submissionsSb = new StringBuffer();
		String format;
		String formatCode;
		String bundleStr;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				if(i>1) {
					submissionsSb.append(st+",");
				}
				i++;
			}
			String[] submissionArr = (submissionsSb.toString().substring(0, submissionsSb.toString().length()-1)).split(",");
			for(String submissionStr : submissionArr) {
//				System.out.println("submissionStr: " + submissionStr);
				String[] arr = submissionStr.split("\\|");
				format = arr[0].trim();
				formatCode = arr[1].trim();	
				bundleStr = arr[2];
				Submission submission = new Submission(format, formatCode, bundleStr);
				submissions.add(submission);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return submissions;
	}
	
	public static List<Bundle> getBundleListByFormateCode(String formateCode,List<Submission> submissions){
		List<Bundle> bundleList = new ArrayList<Bundle>();
		for(Submission submission:submissions) {
			if(submission.getFormateCode().equalsIgnoreCase(formateCode)) {
				bundleList = submission.getBundles();
			}
		}
		return bundleList;
	}
	
	public static List<Output> bundleCalculator(List<Submission> submissions, List<Order> orders){
		List<Output> outputs = new ArrayList<Output>();
		for(Order order:orders) {
			int totalAmount = order.getAmount();
			String formateCode = order.getFormateCode();
			List<Bundle> bundleList = getBundleListByFormateCode(formateCode, submissions);
			Output output = breakDownCalculator(formateCode,totalAmount,bundleList);
			outputs.add(output);
		}
		return outputs;
	}
	
	
	public static Output breakDownCalculator(String formateCode, int totalAmount, List<Bundle>bundles) {
		Output output = new Output();
		output.setAmount(totalAmount);
		output.setFormateCode(formateCode);
		TreeMap<Bundle,Integer> bundlesMap = new TreeMap<Bundle,Integer>();
		Collections.sort(bundles);
		Collections.reverse(bundles);
		Integer reminder = totalAmount;
		int start = 0;
		int initialTotalAmount = totalAmount;
		while(reminder!=0) {
			bundlesMap.clear();
			for(int i=start;i<bundles.size();i++) {
				if(totalAmount/bundles.get(i).getAmount()>0) {
					bundlesMap.put(bundles.get(i),totalAmount/bundles.get(i).getAmount());
					reminder = totalAmount%bundles.get(i).getAmount();
					if(reminder == 0) {
						break;
					}
					totalAmount = reminder;
				}else {
					continue;
				}
			}
			totalAmount = initialTotalAmount;
			start++;
		}
		output.setBundles(bundlesMap);
		output.setTotalPrice(getTotalPricleForBundles(bundlesMap));
		System.out.println(output);
		return output;
		
	} 
	
	public static Double getTotalPricleForBundles(Map<Bundle,Integer> bundlesMap) {
		Double totalPrice = 0.0;
		for(Map.Entry<Bundle,Integer> entry:bundlesMap.entrySet()) {
			int amount = entry.getValue();
			double unitPrice = entry.getKey().getPrice();
			totalPrice += amount * unitPrice;
		}
//		System.out.println("total price: " + totalPrice);
		return totalPrice;
	}
	
	public static void printOutputsToFile(List<Output> outputs) {
		StringBuilder sb = new StringBuilder();
		for(Output output:outputs) {
			sb.append(output.toString());
		}
	    String str = sb.toString();
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("./src/Outputs.txt"));
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
