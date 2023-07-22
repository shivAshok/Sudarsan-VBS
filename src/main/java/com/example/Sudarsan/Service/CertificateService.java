package com.example.Sudarsan.Service;

import com.example.Sudarsan.Dtos.ResponseDto.ResponseCentre;
import com.example.Sudarsan.Dtos.ResponseDto.ResponseCertificate;
import com.example.Sudarsan.Exceptions.AppointmentNotPresent;
import com.example.Sudarsan.Model.Appointment;
import com.example.Sudarsan.Model.Certificate;
import com.example.Sudarsan.Model.Doctor;
import com.example.Sudarsan.Model.Person;
import com.example.Sudarsan.Repository.ApointmentRepo;
import com.example.Sudarsan.Repository.CertificateRepo;
import com.example.Sudarsan.Repository.DoctorRepo;
import com.example.Sudarsan.Repository.PersonRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@Service
public class CertificateService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    PersonRepo personRepo;
    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    ApointmentRepo appointmentRepo;
    @Autowired
    CertificateRepo certificateRepo;
    public ResponseCertificate generateCertificate(int ap_id) throws MessagingException {
        Optional<Appointment> isAppointment=appointmentRepo.findById(ap_id);
        if(isAppointment.isEmpty()){
            throw new AppointmentNotPresent("Appointment with this id not present");
        }
        Appointment ap=isAppointment.get();
        Person person=ap.getPerson();
        Doctor doctor=ap.getDoctor();
        Certificate certificate=new Certificate();
        certificate.setPerson(person);
        certificate.setCerificateId(String.valueOf(UUID.randomUUID()));
        person.setCertificate(certificate);
        Person savedPerson=personRepo.save(person);

        MimeMessage message = mailSender.createMimeMessage();
         String dose1date="Not Taken";
        if(savedPerson.getDosesTaken().size()>0) {
            dose1date=""+savedPerson.getDosesTaken().get(0).getVaccinationDate();
        }
        String dose2date="Not Taken";
        if(savedPerson.getDosesTaken().size()>1) {
            dose2date=""+savedPerson.getDosesTaken().get(savedPerson.getDosesTaken().size()-1).getVaccinationDate();
        }
        String text="Person Name "+savedPerson.getName()+"\n"+
                    "Age::"+savedPerson.getAge()+"\n"+
                    "person id "+savedPerson.getId()+"\n"+
                     "email Id "+savedPerson.getEmailId()+"\n"+
                    "Gender :"+savedPerson.getGender()+"\n"+
                    "dose 1 :"+savedPerson.isDose1Taken()+" "+dose1date+"\n"+
                    "dose 2 :"+savedPerson.isDose2Taken()+" "+dose2date+"\n"+
                    "doctor name : "+doctor.getName();





        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setFrom("acciojobteamrecruiter184@gmail.com");
        helper.setTo(savedPerson.getEmailId());
        helper.setSubject("certificate");
        helper.setText(text);

      FileSystemResource file
                = new FileSystemResource(new File("/Users/sm096/OneDrive/Documents/btech.jpg"));
        helper.addAttachment(file.getFilename(), file );
    try {
        mailSender.send(message);
    }
    catch(MailException ex){
        System.out.println(ex.getMessage());
    }
        ResponseCertificate certificate1=new ResponseCertificate();
        certificate1.setPersonName(savedPerson.getName());
        certificate1.setAge((savedPerson.getAge()));
        certificate1.setGender(savedPerson.getGender());
        certificate1.setDoctorName(doctor.getName());
        if(savedPerson.getDosesTaken().size()>0) {
            certificate1.setDose1date(savedPerson.getDosesTaken().get(0).getVaccinationDate());
        }
        if(savedPerson.getDosesTaken().size()>1) {
            certificate1.setDose2daten(savedPerson.getDosesTaken().get(savedPerson.getDosesTaken().size() - 1).getVaccinationDate());
        }
        certificate1.setDose1Taken(savedPerson.isDose1Taken());
        certificate1.setDose2Taken(savedPerson.isDose2Taken());

        ResponseCentre centre=new ResponseCentre();
        centre.setCentreType(doctor.getCentre().getCentreType());
        centre.setName(doctor.getCentre().getCentreName());
        centre.setMsg(person.getName()+" is vaccinated "+doctor.getCentre().getCentreName());

        certificate1.setCentre(centre);

        return certificate1;
    }
}
