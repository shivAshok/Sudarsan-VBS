package com.example.Sudarsan.Exceptions;

public class AppointmentNotPresent extends RuntimeException{
    public AppointmentNotPresent(String msg){
        super(msg);
    }
}
