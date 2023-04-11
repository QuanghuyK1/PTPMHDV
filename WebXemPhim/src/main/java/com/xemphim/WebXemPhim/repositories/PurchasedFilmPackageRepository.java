package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.PurchasedFilmPackage;
import com.xemphim.WebXemPhim.models.PurchasedFilmPackageId;

public interface PurchasedFilmPackageRepository extends JpaRepository<PurchasedFilmPackage, PurchasedFilmPackageId>{

}
