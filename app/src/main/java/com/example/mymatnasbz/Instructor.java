package com.example.mymatnasbz;

public class Instructor extends User{

    public Boolean IsInstructor;

    public Instructor(String id, String userName, String email, String password, Boolean isInstructor) {
        super(id, userName, email, password);
        IsInstructor = isInstructor;
    }

    public Instructor(String id, String userName, String email, String password) {
        super(id, userName, email, password);
        IsInstructor = false;


    }
}


