package com.civa.retotecnico.controllers;

import com.civa.retotecnico.model.Brand;
import com.civa.retotecnico.model.DataBus;
import com.civa.retotecnico.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public Page<DataBus> busList(@PageableDefault(size=10, sort ={"busNumber"}) Pageable page) {
        return busService.busList(page);
    }

    @GetMapping("/{id}")
    public DataBus busDetail(@PathVariable UUID id){
        return busService.busDetail(id);
    }
}
