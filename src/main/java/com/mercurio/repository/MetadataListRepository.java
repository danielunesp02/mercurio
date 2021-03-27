package com.mercurio.repository;

import com.mercurio.model.MetadataList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataListRepository extends JpaRepository<MetadataList, Long> {
}
