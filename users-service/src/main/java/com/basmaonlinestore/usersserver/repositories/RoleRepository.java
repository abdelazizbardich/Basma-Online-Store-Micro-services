package com.basmaonlinestore.usersserver.repositories;

import com.basmaonlinestore.usersserver.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
