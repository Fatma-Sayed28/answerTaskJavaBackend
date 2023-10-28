package com.fileproject.Springtask.controller;

import com.fileproject.Springtask.model.Permissions;
import com.fileproject.Springtask.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stc-assessments/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionsService;

    @GetMapping
    public ResponseEntity<List<Permissions>> getAllPermissions() {
        List<Permissions> permissions = permissionsService.getAllPermissions();
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Permissions> getPermissionById(@PathVariable Long id) {
        Optional<Permissions> permission = permissionsService.getPermissionById(id);
        return permission.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Permissions> createPermission(@RequestBody Permissions permissions) {
        Permissions createdPermission = permissionsService.createPermission(permissions);
        return new ResponseEntity<>(createdPermission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permissions> updatePermission( @RequestBody Permissions updatedPermission) {
        Permissions updated = permissionsService.updatePermission( updatedPermission);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionsService.deletePermission(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
