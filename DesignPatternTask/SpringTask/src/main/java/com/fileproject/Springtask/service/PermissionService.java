package com.fileproject.Springtask.service;

import com.fileproject.Springtask.model.Permissions;
import com.fileproject.Springtask.repository.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepo permissionRepository;

    public List<Permissions> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Optional<Permissions> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    public Permissions createPermission(Permissions permission) {
        return permissionRepository.save(permission);
    }

    public Permissions updatePermission( Permissions updatedPermission) {

            return permissionRepository.save(updatedPermission);

    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
