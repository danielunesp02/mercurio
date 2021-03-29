package com.mercurio.repository;

import com.mercurio.model.DocumentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentAttributeRepository extends JpaRepository<DocumentAttribute, Long> {
}
