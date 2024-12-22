package net.javaguides.com.repository;

import net.javaguides.com.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
