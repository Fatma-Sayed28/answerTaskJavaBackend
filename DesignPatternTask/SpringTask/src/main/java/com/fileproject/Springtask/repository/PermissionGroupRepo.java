package com.fileproject.Springtask.repository;

import com.fileproject.Springtask.model.PermissionGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionGroupRepo extends JpaRepository<PermissionGroups,Long> {
}
