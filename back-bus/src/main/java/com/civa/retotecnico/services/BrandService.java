package com.civa.retotecnico.services;

import com.civa.retotecnico.model.Brand;
import com.civa.retotecnico.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void addBrand(Brand brandAdd) {
        brandRepository.save(brandAdd);
    }
}
