package com.fileproject.Springtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "permission_level")
    private String permissionLevel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private PermissionGroups permissionGroups;
}