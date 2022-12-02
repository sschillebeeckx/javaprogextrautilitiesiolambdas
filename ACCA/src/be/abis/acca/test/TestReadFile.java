package be.abis.acca.test;

import be.abis.acca.model.Address;
import be.abis.acca.repository.AddressRepository;
import be.abis.acca.repository.FileAddressRepository;

import java.util.Comparator;
import java.util.List;

public class TestReadFile {

    public static void main(String[] args) {
        AddressRepository ar = new FileAddressRepository();

        System.out.println("ALL ADDRESSES:");
        ar.findAllAddresses().forEach(System.out::println);

        System.out.println("\nFIND ADDRESS BY STREET,NR, AND ZIPCODE:");
        System.out.println(ar.findAddress("Diestsevest","32 bus 4B","3000"));

        System.out.println("\nFIND ADDRESS BY NR, AND ZIPCODE:");
        System.out.println(ar.findAddress("70","6411 EJ"));

        System.out.println("\nINSERT ADDRESS");
        Address a = new Address("Some street","1","1000","Brussels","Belgium","B");
        ar.insertAddress(a);
        ar.findAllAddresses().forEach(System.out::println);

        System.out.println("\nSORT ADDRESSES BY ZIPCODE");
        ar.findAllAddresses().stream().sorted((a1,a2)->a1.getZipCode().compareTo(a2.getZipCode())).forEach(System.out::println);

        System.out.println("\nSORT ADDRESSES BY COUNTRY AND TOWN");
        ar.findAllAddresses().stream().sorted(Comparator.comparing(Address::getCountryCode).thenComparing(Address::getTown)).forEach(System.out::println);


    }
}
