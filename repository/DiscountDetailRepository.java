package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.DiscountDetail;
import com.xemphim.WebXemPhim.entity.DiscountDetailId;

public interface DiscountDetailRepository extends JpaRepository<DiscountDetail, DiscountDetailId>{

}
