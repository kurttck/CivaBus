package com.civa.retotecnico.services;

import com.civa.retotecnico.model.Brand;
import com.civa.retotecnico.model.Bus;
import com.civa.retotecnico.model.DataBus;
import com.civa.retotecnico.repository.BrandRepository;
import com.civa.retotecnico.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    public Page<DataBus> busList(Pageable page) {

        /*
        OPCIONAL PARA AGREGAR DATOS MEDIANTE LA APLICACION

        var brand1 = new Brand();
        brand1.setName("Toyota");

        Optional<Brand> response = brandRepository.findByName(brand1.getName());

        if(response.isEmpty()){
            brandService.addBrand(brand1);

        }else{
            brand1 = response.get();
        }

        var busAdd1 = new Bus();
        busAdd1.setBusNumber(1);
        busAdd1.setPlate("AEJ-174");
        busAdd1.setCreationDate(LocalDate.now());
        busAdd1.setFeatures("Azul, 4 puertas");
        busAdd1.setBrand(brand1);
        busAdd1.setStatus(true);

        busRepository.save(busAdd1);
*/



        return busRepository.findByStatusTrue(page).map(bus -> new DataBus(bus));
    }

    public DataBus busDetail(UUID id) {
        return busRepository.findById(id).map(bus -> new DataBus(bus)).orElse(null);
    }
}
