package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.DiscountDetail;
import com.xemphim.WebXemPhim.models.DiscountDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountDetailRepository extends JpaRepository<DiscountDetail, DiscountDetailId>{

}
