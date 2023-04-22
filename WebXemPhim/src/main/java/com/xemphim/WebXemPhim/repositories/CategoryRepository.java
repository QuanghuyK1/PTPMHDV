package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    Category findByCategoryName(String category);

}
