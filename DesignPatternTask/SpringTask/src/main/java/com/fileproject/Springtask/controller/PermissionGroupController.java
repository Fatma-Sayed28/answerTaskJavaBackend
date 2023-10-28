package com.fileproject.Springtask.controller;


import com.fileproject.Springtask.model.PermissionGroups;
import com.fileproject.Springtask.service.PermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stc-assessments/permissionGroups")
public class PermissionGroupController {

    @Autowired
    private PermissionGroupService permissionGroupService;

    @GetMapping
    public ResponseEntity<List<PermissionGroups>> getAllPermissionGroups() {
        List<PermissionGroups> permissionGroups = permissionGroupService.getAllPermissionGroups();
        return new ResponseEntity<>(permissionGroups, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PermissionGroups> getPermissionGroupById(@PathVariable Long id) {
        Optional<PermissionGroups> permissionGroup = permissionGroupService.getPermissionGroupById(id);
        return permissionGroup.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PermissionGroups> createPermissionGroup(@RequestBody PermissionGroups permissionGroup) {
        PermissionGroups createdPermissionGroup = permissionGroupService.createPermissionGroup(permissionGroup);
        return new ResponseEntity<>(createdPermissionGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionGroups> updatePermissionGroup( @RequestBody PermissionGroups updatedPermissionGroup) {
        PermissionGroups updated = permissionGroupService.updatePermissionGroup( updatedPermissionGroup);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissionGroup(@PathVariable Long id) {
        permissionGroupService.deletePermissionGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
