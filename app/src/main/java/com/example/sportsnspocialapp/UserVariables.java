package com.example.sportsnspocialapp;

import android.app.Application;

public class UserVariables extends Application{
//    UserVariables userVariables = (UserVariables) getApplicationContext();


    public String getOponentID() {
        return oponentID;
    }

    public void setOponentID(String oponentID) {
        this.oponentID = oponentID;
    }

    public String oponentID;

    // Getter

}
