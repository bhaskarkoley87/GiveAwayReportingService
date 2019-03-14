package com.hackfse.giveaway.component;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfse.giveaway.service.ReportingService;
import com.hackfse.giveaway.util.CommonUtil;



@RestController
@RequestMapping(value="/report")
public class GenerateReport {

	@Autowired
	ReportingService reportingService;
	
	
	CommonUtil commonUtil;
	
	private static String[] columns = {"Item Category", "Item Name", "Item Count", "Item Status", "Date of submition", "Month of Submition", "Quarter of Submition", "Year of Submition", "Month Date of Submition", "Submited By"};
	
	@RequestMapping(value="/inventry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public String[]  generateReportForInventry(@RequestParam String itemCategory, @RequestParam String itemStatus, @RequestParam Long qutrValue, @RequestParam Long yrValue, @RequestParam String userId) throws IOException{
		String[] responseData = new String[2];
		commonUtil = new CommonUtil();
		List<Object[]> lstReportData = reportingService.getReportForInventry(itemCategory, itemStatus.trim(), qutrValue, yrValue, userId);
		String strFileData = reportingService.generateReportExcel(columns, lstReportData, "Inventry_Report_"+System.currentTimeMillis());
		String strReportData = commonUtil.writeListToJsonArray(lstReportData);
		responseData[0] = strReportData;
		responseData[1] = strFileData;
		return responseData;
	}
}
