package com.softkali.buddha_suddha.addressbook.repository;


import com.softkali.buddha_suddha.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBookModel,Long> {
    Optional<List<AddressBookModel>> findByUserId(String userId);
}
