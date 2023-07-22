package com.example.Sudarsan.Exceptions;

public class PersonNotpresent extends RuntimeException{
     public PersonNotpresent(){
         super("person not present with this id");
     }


}
