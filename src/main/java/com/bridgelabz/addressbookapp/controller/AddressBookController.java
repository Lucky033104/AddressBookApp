package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @GetMapping
    public List<AddressBookData> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AddressBookData getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public AddressBookData create(@RequestBody AddressBookDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public AddressBookData update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
