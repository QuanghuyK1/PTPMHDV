package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.DiscountDetail;
import com.xemphim.WebXemPhim.models.DiscountDetailId;

public interface DiscountDetailRepository extends JpaRepository<DiscountDetail, DiscountDetailId>{

}
