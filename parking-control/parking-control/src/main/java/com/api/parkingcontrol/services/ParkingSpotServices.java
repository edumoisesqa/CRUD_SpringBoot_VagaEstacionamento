package com.api.parkingcontrol.services;


import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.Repositories.ParkingSpotRepository;
import com.api.parkingcontrol.models.ParkingSpotModel;

import jakarta.transaction.Transactional;


@Service
public class ParkingSpotServices {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotServices(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean exitsByApartamentAndBlock(String apartament, String Block) {
        return parkingSpotRepository.existsByApartamentAndBlock(apartament, Block);
    }



    public List<ParkingSpotModel> findAll(){
        return parkingSpotRepository.findAll();
    }

}
