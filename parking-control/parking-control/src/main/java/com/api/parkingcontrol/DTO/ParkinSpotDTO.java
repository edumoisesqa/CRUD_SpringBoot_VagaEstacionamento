package com.api.parkingcontrol.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParkinSpotDTO{

    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    @Size(max=7)
    private String licensePlateCar;
    @NotBlank
    private String brandCAr;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartament;
    @NotBlank
    private String block;
    
    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }
    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }
    public String getLicensePlateCar() {
        return licensePlateCar;
    }
    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }
    public String getBrandCAr() {
        return brandCAr;
    }
    public void setBrandCAr(String brandCAr) {
        this.brandCAr = brandCAr;
    }
    public String getModelCar() {
        return modelCar;
    }
    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }
    public String getColorCar() {
        return colorCar;
    }
    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }
    public String getResponsibleName() {
        return responsibleName;
    }
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }
    public String getApartament() {
        return apartament;
    }
    public void setApartament(String apartament) {
        this.apartament = apartament;
    }
    public String getBlock() {
        return block;
    }
    public void setBlock(String block) {
        this.block = block;
    }
}