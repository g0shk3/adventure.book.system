package com.advance.academy.adventure.book.system.repository;

import com.advance.academy.adventure.book.system.model.Customer;
import com.advance.academy.adventure.book.system.model.enums.UserType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {


    @Query("SELECT c FROM  Customer c where userType=:userType")
    List<Customer> getByUserType(@Param("userType") UserType userType);

    @Query(value = "SELECT c.* FRROM  ustomers c where c.user_type=:userType", nativeQuery = true)
    List<Customer> getByUserTypeNativeQuery(@Param("userType") UserType userType);

    @Modifying
    @Query("UPDATE Customer SET isDeleted = true WHERE id = :customerId")
    void deactivateCustomer(@Param("customerId") Integer id);


}
