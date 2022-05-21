package com.basmaonlinestore.usersserver.repositories;

import com.basmaonlinestore.usersserver.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
