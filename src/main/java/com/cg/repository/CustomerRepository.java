package com.cg.repository;

import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFullNameLike(String fullName);

    List<Customer> findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String fullName, String email, String phone, String address);


    @Query(value = "SELECT " +
                "c.id, " +
                "c.full_name, " +
                "c.email, " +
                "c.phone, " +
                "c.address " +
            "FROM customers AS c " +
            "WHERE c.id LIKE :searchKey " +
            "OR c.full_name LIKE :searchKey " +
            "OR c.email LIKE :searchKey " +
            "OR c.phone LIKE :searchKey " +
            "OR c.address LIKE :searchKey", nativeQuery = true
    )
    List<Customer> findAllBySearchKey(@Param("searchKey") String searchKey);

}
