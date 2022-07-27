package com.codingquokka.hansungenquete.domain;

import java.util.Date;

public class ElectionVO {
	   
    private String electionName;
    private Date startDate;
    private Date endDate;
    private String explain;
    private String department;


    public String getElectionName() {
        return electionName;
    }
    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getExplain() {
    	return explain;
    }
    public void setExplain(String explain) {
    	this.explain = explain;
    }
    public String getDepartment() {
    	return department;
    }
    public void setDepartment(String department) {
    	this.department = department;
    }

    }


