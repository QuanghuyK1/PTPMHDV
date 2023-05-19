package com.xemphim.WebXemPhim.output;

import java.util.Date;

public class PurchaseHistoryOutput {
	private Integer filmPackageID;
	private Date purchaseDate;
	private Date startDate;
	private Date expirationDate;
	private Integer status;
	public PurchaseHistoryOutput() {
		super();
	}
	public PurchaseHistoryOutput(Integer filmPackageID, Date purchaseDate, Date startDate, Date expirationDate, Integer status) {
		super();
		this.filmPackageID = filmPackageID;
		this.purchaseDate = purchaseDate;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
	}
	public Integer getFilmPackageID() {
		return filmPackageID;
	}
	public void setFilmPackageID(Integer filmPackageID) {
		this.filmPackageID = filmPackageID;
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
