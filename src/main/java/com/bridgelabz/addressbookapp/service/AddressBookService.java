package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService implements IAddressBookService {

    private List<AddressBookData> addressList = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<AddressBookData> getAll() {
        return addressList;
    }

    @Override
    public AddressBookData getById(int id) {
        return addressList.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData create(AddressBookDTO dto) {
        AddressBookData newData = new AddressBookData(idCounter.getAndIncrement(), dto.name, dto.city);
        addressList.add(newData);
        return newData;
    }

    @Override
    public AddressBookData update(int id, AddressBookDTO dto) {
        this.delete(id);
        AddressBookData updated = new AddressBookData(id, dto.name, dto.city);
        addressList.add(updated);
        return updated;
    }

    @Override
    public void delete(int id) {
        addressList.removeIf(a -> a.getId() == id);
    }
}
