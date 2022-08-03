package com.SoulCode.Services.Repositories;

import com.SoulCode.Services.Models.Address;

import com.SoulCode.Services.Models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {


}
