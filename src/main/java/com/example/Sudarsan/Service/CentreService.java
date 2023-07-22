package com.example.Sudarsan.Service;

import com.example.Sudarsan.Dtos.Requestdtos.RequestCentre;
import com.example.Sudarsan.Dtos.ResponseDto.ResponseCentre;
import com.example.Sudarsan.Model.VaccinationCentre;
import com.example.Sudarsan.Repository.CerntreRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service

public class CentreService {
    @Autowired
    CerntreRepo centreRepo;
    public ResponseCentre addCentre(RequestCentre centre) {
        VaccinationCentre curcentre=new VaccinationCentre();
        curcentre.setCentreType(centre.getCentreType());
        curcentre.setAdress(centre.getAdress());
        curcentre.setCentreName(centre.getCentreName());
      VaccinationCentre savedCentre=  centreRepo.save(curcentre);


        ResponseCentre response=new ResponseCentre();
        response.setCentreType(savedCentre.getCentreType());
        response.setName(savedCentre.getCentreName());
        response.setMsg("centre added successfully");

        return response;
    }
}
