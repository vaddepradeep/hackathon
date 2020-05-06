package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="slotinfo")
public class SlotEntity {
	@Id
	private int slotid;
	private String type;
	private String status;
	public int getSlotid() {
		return slotid;
	}
	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
