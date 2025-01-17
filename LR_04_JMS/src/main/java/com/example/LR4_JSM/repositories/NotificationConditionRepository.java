package com.example.LR4_JSM.repositories;

import com.example.LR4_JSM.entities.NotificationCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationConditionRepository extends JpaRepository<NotificationCondition, Long> {
    List<NotificationCondition> findByEntityName(String entityName);
}