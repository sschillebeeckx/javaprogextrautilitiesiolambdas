package be.abis.acca.repository;

import be.abis.acca.model.Address;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAddressRepository implements AddressRepository {

    private List<Address> addressList = new ArrayList<Address>();
    private String filePath="ACCA/src/addresses.csv";

    public FileAddressRepository() {
       this.readFile();
    }

    public void readFile(){
        if(addressList.size()!=0)addressList.clear();
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            while ((line = br.readLine()) != null) {
                addressList.add(this.parseToAddress(line));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Address> findAllAddresses() {
        this.readFile();
        return addressList;
    }

    @Override
    public Address findAddress(String street, String nr, String zipCode) {
        Address found=null;
        for (Address a : addressList){
            if (a.getStreet().equals(street)&&a.getNr().equals(nr)&&a.getZipCode().equals(zipCode)){
                found=a;
            }
        }
        return found;
    }

    @Override
    public Address findAddress(String nr, String zipCode) {
        return addressList.stream().filter(a->a.getNr().equals(nr)&&a.getZipCode().equals(zipCode)).findFirst().orElse(null);
    }

    @Override
    public void insertAddress(Address a) {
        addressList.add(a);
        String lineToAdd = this.convertToFileAddress(a);
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))){
            pw.append(lineToAdd+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Address parseToAddress(String line){
        String[] values = line.split(";");
        Address a = new Address();
        a.setStreet(values[0]);
        a.setNr(values[1]);
        a.setZipCode(values[2]);
        a.setTown(values[3]);
        a.setCountry(values[4]);
        a.setCountryCode(values[5]);
        return a;
    }
    private String convertToFileAddress(Address a){
        StringBuilder sb = new StringBuilder("");
        sb.append(a.getStreet()).append(";")
                .append(a.getNr()).append(";")
                .append(a.getZipCode()).append(";")
                .append(a.getTown()).append(";")
                .append(a.getCountry()).append(";")
                .append(a.getCountryCode());
        return sb.toString();
    }

}
