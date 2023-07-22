package com.example.Sudarsan.Service;

import com.example.Sudarsan.Dtos.Requestdtos.ResponseDoctor;
import com.example.Sudarsan.Dtos.ResponseDto.RequestDoctor;
import com.example.Sudarsan.Dtos.ResponseDto.ResponseCentre;
import com.example.Sudarsan.Model.Doctor;
import com.example.Sudarsan.Model.VaccinationCentre;
import com.example.Sudarsan.Repository.CerntreRepo;
import com.example.Sudarsan.Repository.DoctorRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class DoctorService {
    @Autowired
    CerntreRepo centreRepo;
    @Autowired
    DoctorRepo doctorRepo;

    public ResponseDoctor addDoctor(RequestDoctor requestDoctor) {
        Optional<VaccinationCentre> centre=centreRepo.findById(requestDoctor.getCentre_Id());
        if(centre.isEmpty()){
            throw new RuntimeException("centre not present");
        }
        VaccinationCentre currCentre=centre.get();
        Doctor dt=new Doctor();
        dt.setName(requestDoctor.getName());
        dt.setAge(requestDoctor.getAge());
        dt.setGender(requestDoctor.getGender());
        dt.setEmailId(requestDoctor.getEmailId());
        dt.setCentre(currCentre);
        currCentre.getDoctors().add(dt);
        VaccinationCentre vcs=centreRepo.save(currCentre);

        ResponseDoctor rd=new ResponseDoctor();
        rd.setDtname(dt.getName());
        rd.setMsg("doctor added successfully");
        ResponseCentre rs=new ResponseCentre();
        rs.setName(vcs.getCentreName());
        rs.setCentreType(vcs.getCentreType());
        rs.setMsg("My centre");
        rd.setResponse(rs);
        return rd;
    }
}
