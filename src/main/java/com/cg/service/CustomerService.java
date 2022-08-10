package com.cg.service;

import com.cg.model.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerService extends IGeneralService<Customer> {

    List<Customer> findByFullNameLike(String fullName);

    List<Customer> findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String fullName, String email, String phone, String address);

    List<Customer> findAllBySearchKey(@Param("searchKey") String searchKey);
}
