package com.xemphim.WebXemPhim.repository;

import java.util.Date;
import java.util.List;

import com.xemphim.WebXemPhim.entity.Account;
import com.xemphim.WebXemPhim.entity.FilmPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.xemphim.WebXemPhim.entity.PurchasedFilmPackage;
import com.xemphim.WebXemPhim.entity.PurchasedFilmPackageId;

@EnableJpaRepositories
public interface PurchasedFilmPackageRepository extends JpaRepository<PurchasedFilmPackage, PurchasedFilmPackageId>{
	@Query(value = "SELECT fp.used_time FROM web_phim.purchased_film_packages pfp JOIN web_phim.film_packages fp ON pfp.film_package_id = fp.film_package_id WHERE pfp.start_date <= CURDATE() AND pfp.expiration_date >= CURDATE() AND account_name = :acc_name AND pfp.status = 1 ORDER BY pfp.purchase_date DESC LIMIT 1;",
            nativeQuery = true)
    List<Object[]> getFilmPackageForClient(@Param("acc_name") String acc_name);
    
    @Query(value = "SELECT used_time, purchase_date, start_date, expiration_date, pfp.status FROM web_phim.purchased_film_packages pfp JOIN web_phim.film_packages fp ON pfp.film_package_id = fp.film_package_id  WHERE pfp.account_name = :acc_name ;",
            nativeQuery = true)
    List<Object[]> getPurchaseHistory(@Param("acc_name") String acc_name);
    @Query(value = "SELECT * FROM web_phim.purchased_film_packages pfp WHERE pfp.account_name = :acc_name AND pfp.film_package_id = :id AND pfp.purchase_date = :time  ;",
            nativeQuery = true)
    PurchasedFilmPackage getPackage(@Param("acc_name") String acc_name,@Param("id") String id,@Param("time") String time);

    PurchasedFilmPackage findOneByIdAccountAndIdFilmPackageAndStatusTrue(Account account, FilmPackage filmPackage);

    PurchasedFilmPackage findOneByIdAccountAndIdFilmPackageAndStatusFalse(Account account, FilmPackage filmPackage);

    PurchasedFilmPackage findOneByIdAccountAndIdFilmPackageAndIdPurchaseDateAndStatusFalse(Account account, Date date, FilmPackage filmPackage);
}
