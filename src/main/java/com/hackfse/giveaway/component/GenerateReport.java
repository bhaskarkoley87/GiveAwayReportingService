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
	
	@RequestMapping(value="/inventry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public String  generateReportForInventry(@RequestParam String itemCategory, @RequestParam String itemStatus, @RequestParam Long qutrValue, @RequestParam Long yrValue, @RequestParam String userId) throws IOException{
		commonUtil = new CommonUtil();
		List<Object[]> lstReportData = reportingService.getReportForInventry(itemCategory.trim().equalsIgnoreCase("") ? null : itemCategory.trim().equalsIgnoreCase("null") ? null : itemCategory.trim(), itemStatus.trim().equalsIgnoreCase("") ? null : itemStatus.trim().equalsIgnoreCase("null") ? null : itemStatus.trim(), qutrValue.toString().trim().equalsIgnoreCase("") ? null : qutrValue.toString().trim().equalsIgnoreCase("null") ? null : qutrValue.toString().trim().equalsIgnoreCase("0") ? null : qutrValue, yrValue.toString().trim().equalsIgnoreCase("") ? null : yrValue.toString().trim().equalsIgnoreCase("null") ? null : yrValue.toString().trim().equalsIgnoreCase("0") ? null : yrValue, userId.trim().equalsIgnoreCase("") ? null : userId.trim().equalsIgnoreCase("null") ? null : userId.trim());
		String strReportData = commonUtil.writeListToJsonArray(lstReportData);
		return strReportData;
	}
}
