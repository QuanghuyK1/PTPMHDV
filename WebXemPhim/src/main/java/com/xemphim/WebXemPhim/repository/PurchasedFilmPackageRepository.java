package com.xemphim.WebXemPhim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.xemphim.WebXemPhim.entity.PurchasedFilmPackage;
import com.xemphim.WebXemPhim.entity.PurchasedFilmPackageId;

@EnableJpaRepositories
public interface PurchasedFilmPackageRepository extends JpaRepository<PurchasedFilmPackage, PurchasedFilmPackageId>{
	@Query(value = "SELECT * FROM web_phim.purchased_film_packages pfp WHERE pfp.start_date <= CURDATE() AND pfp.expiration_date >= CURDATE() AND account_name = :acc_name AND pfp.status = 1;",
            nativeQuery = true)
    List<Object[]> getFilmPackageForClient(@Param("acc_name") String acc_name);
    
    @Query(value = "CALL get_purchase_history(:acc_name);", nativeQuery = true)
    List<Object[]> getPurchaseHistory(@Param("acc_name") String acc_name);
}
