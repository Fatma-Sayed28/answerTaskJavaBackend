package com.fileproject.Springtask.service;

import com.fileproject.Springtask.model.PermissionGroups;
import com.fileproject.Springtask.repository.PermissionGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionGroupService {
    @Autowired
    private PermissionGroupRepo permissionGroupRepo;

    public List<PermissionGroups> getAllPermissionGroups() {
        return permissionGroupRepo.findAll();
    }

    public Optional<PermissionGroups> getPermissionGroupById(Long id) {
        return permissionGroupRepo.findById(id);
    }

    public PermissionGroups createPermissionGroup(PermissionGroups permissionGroup) {
        return permissionGroupRepo.save(permissionGroup);
    }

    public PermissionGroups updatePermissionGroup(PermissionGroups updatedPermissionGroup) {
            return permissionGroupRepo.save(updatedPermissionGroup);

        }

    public void deletePermissionGroup(Long id) {
        permissionGroupRepo.deleteById(id);
    }
}
