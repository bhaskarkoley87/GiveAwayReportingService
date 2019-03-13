package com.hackfse.giveaway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.giveaway.dao.InventoryManagementDao;

@Service
public class ReportingService {

	@Autowired
	InventoryManagementDao inventoryManagementDao;

	public List<Object[]> getReportForInventry(String itemCategory, String itemStatus, Long qutrValue, Long yrValue,
			String userId) {
		List<Object[]> lstReportData = new ArrayList<Object[]>();
		System.out.println("DATA OUTPUT : "+itemCategory+" :::: "+itemStatus+" :::: "+qutrValue+" :::: "+yrValue+" :::: "+userId);
		lstReportData = inventoryManagementDao.getInventoryReport(itemCategory, itemStatus, qutrValue, yrValue, userId);
		return lstReportData;
		
	}
	
	
}
