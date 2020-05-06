package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ResStatus;
import com.example.demo.repo.SlotRepo;

@Service
public class parkingServiceImpl implements ParkingavilabulityService{
	
	@Autowired	
	private SlotRepo slotrepo;

	@Override
	public ResStatus  checkSlotAvilableService(String type) {
		
		ResStatus  resStatus= new ResStatus();
		boolean b=slotrepo.checkSlotAvilabulity(type, "avilable");
		System.out.println(b);
		
		if(b)
		{
	List<Integer> slotlist=slotrepo.findAvilableSlots(type, "avilable");
			ArrayList al= new ArrayList(slotlist);
			
			Integer i=(int) al.get(0);
					
			
			
			
		slotrepo.updateStatus(i,"filled");
			String s=i.toString();
			resStatus.setStatuscode(200);
			resStatus.setStatusmsg("your vehicle was alloted to"+" "+s+" "+"slot" );
		
		return 	resStatus;
				
		}
		else
		{
			resStatus.setStatuscode(405);
			resStatus.setStatusmsg("slots was filled please wait");
			
			return resStatus;
		}
		}
}

	