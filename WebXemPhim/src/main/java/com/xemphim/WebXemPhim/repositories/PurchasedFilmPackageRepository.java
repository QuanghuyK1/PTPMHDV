package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.PurchasedFilmPackage;
import com.xemphim.WebXemPhim.models.PurchasedFilmPackageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedFilmPackageRepository extends JpaRepository<PurchasedFilmPackage, PurchasedFilmPackageId>{

}
