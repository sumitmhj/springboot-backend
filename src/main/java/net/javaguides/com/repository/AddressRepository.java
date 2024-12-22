package net.javaguides.com.repository;

import net.javaguides.com.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
