package com.myProject.ShopShopDay.repository;

import com.myProject.ShopShopDay.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String userRole);
}
