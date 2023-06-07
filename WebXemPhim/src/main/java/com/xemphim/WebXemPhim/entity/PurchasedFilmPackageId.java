package com.xemphim.WebXemPhim.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PurchasedFilmPackageId implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "account_name")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "film_package_id")
	private FilmPackage filmPackage;
	@JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="Asia/Ho_Chi_Minh")
	@JoinColumn(name = "purchase_date")
	private Date purchaseDate;

	public Date getPurchase_date() {
		return purchaseDate;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchaseDate = purchase_date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public FilmPackage getFilmPackage() {
		return filmPackage;
	}

	public void setFilmPackage(FilmPackage filmPackage) {
		this.filmPackage = filmPackage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, filmPackage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchasedFilmPackageId other = (PurchasedFilmPackageId) obj;
		return Objects.equals(account, other.account) && Objects.equals(filmPackage, other.filmPackage);
	}

	@Override
	public String toString() {
		return "PurchasedFilmPackageId [account=" + account + ", filmPackage=" + filmPackage + "]";
	}
}