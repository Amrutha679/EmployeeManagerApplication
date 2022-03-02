package com.mondee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="leaves")
@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="eid")
	private int eid;
	
	@Column(name="employeemail")
	private String employeeMail;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="deptName")
	private String deptName;
	
	@Column(name="fromDate")
	private String fromDate;
	
	@Column(name="toDate")
	private String toDate;
	
	@Column(name="noOfLeaves")
	private int noOfLeaves;
	
	@Column(name="totalLeaves")
	private int totalLeaves;
	
	@Column(name="status")
	private String status;

	
//	public Leave(int id,int eid,String ename,String deptName,String fromDate,String toDate,int noOfLeaves,int totalLeaves,String status) {
//			this.id = id;
//			this.eid = eid;
//			this.deptName = deptName;
//			this.ename = ename;
//			this.fromDate = fromDate;
//			this.toDate = toDate;
//			this.noOfLeaves = noOfLeaves;
//			this.totalLeaves = totalLeaves;
//			this.status = status;	
//	}
//	
//	public Leave() {
//		
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEid(Employee employee) {
		this.eid = eid;
		
	}
}
