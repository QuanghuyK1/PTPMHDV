package com.xemphim.WebXemPhim.output;

import java.util.Date;

public class PurchaseHistoryOutput {
	private Integer used_time;
	private Date purchaseDate;
	private Date startDate;
	private Date expirationDate;
	private Integer status;
	public PurchaseHistoryOutput() {
		super();
	}

	public PurchaseHistoryOutput(Integer used_time, Date purchaseDate, Date startDate, Date expirationDate, Integer status) {
		this.used_time = used_time;
		this.purchaseDate = purchaseDate;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
	}

	public Integer getUsed_time() {
		return used_time;
	}

	public void setUsed_time(Integer used_time) {
		this.used_time = used_time;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
