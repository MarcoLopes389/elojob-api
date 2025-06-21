package com.skillrowz.elojob.infrastructure.persistence.repositories;

import com.skillrowz.elojob.infrastructure.persistence.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SaleJpaRepository extends JpaRepository<SaleEntity, UUID> {
    List<SaleEntity> findByNextOwnerId(UUID buyerId);
    List<SaleEntity> findByPreviousOwnerId(UUID sellerId);
}

