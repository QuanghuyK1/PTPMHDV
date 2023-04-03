package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.PurchasedFilmPackage;
import com.xemphim.WebXemPhim.entity.PurchasedFilmPackageId;

public interface PurchasedFilmPackageRepository extends JpaRepository<PurchasedFilmPackage, PurchasedFilmPackageId>{

}
