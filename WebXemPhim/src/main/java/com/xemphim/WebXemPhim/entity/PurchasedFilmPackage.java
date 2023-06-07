package com.xemphim.WebXemPhim.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchased_film_packages")
public class PurchasedFilmPackage {
	
	@EmbeddedId
	private PurchasedFilmPackageId id;

	private boolean status;
	private Date expiration_date;
	private Date start_date;

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public PurchasedFilmPackageId getId() {
		return id;
	}

	public void setId(PurchasedFilmPackageId id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}