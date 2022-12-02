package be.abis.acca.repository;

import be.abis.acca.model.Address;

import java.util.List;

public interface AddressRepository {

    List<Address> findAllAddresses();

    Address findAddress(String street, String nr,String zipCode);
    Address findAddress(String nr,String zipCode);

    void insertAddress(Address a);

}
