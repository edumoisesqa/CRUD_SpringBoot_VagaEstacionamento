package com.api.parkingcontrol.Controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.parkingcontrol.DTO.ParkinSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotServices;

import jakarta.validation.Valid;
import jakarta.validation.OverridesAttribute.List;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    

    final ParkingSpotServices  parkingSpotServices;


    public ParkingSpotController(ParkingSpotServices parkingSpotServices){
        this.parkingSpotServices = parkingSpotServices;
    }


    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkinSpotDTO parkingSpotDto ){
 
         if(parkingSpotServices.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
             return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate car is  alread in use!");
        }

     if(parkingSpotServices.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Parking spot is alread in use");
     }

         if(parkingSpotServices.exitsByApartamentAndBlock(parkingSpotDto.getApartament(), parkingSpotDto.getBlock())){
             return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking spot already registrared for this apartament/block");
     }
      
    var parkingSpotModel = new ParkingSpotModel();  
    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotServices.save(parkingSpotModel));


    }


    @GetMapping
    public  ResponseEntity<List<ParkingSpotModel>>getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }



}
