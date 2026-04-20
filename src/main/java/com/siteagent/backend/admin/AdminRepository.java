package com.siteagent.backend.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findBySiteAdminId(String siteAdminId);

    boolean existsBySiteAdminId(String siteAdminId);
}