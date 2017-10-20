package com.example.gilgamesh.mupy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationNumber extends AppCompatActivity {

    Button button_submit;
    EditText editText_regno;
    String EnteredRegNo;
    Utils.SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_number);

        button_submit = (Button) findViewById(R.id.submit);
        editText_regno = (EditText) findViewById(R.id.RegNo);

        sessionManager = new Utils.SessionManager(this);

        if (sessionManager.isLoggedIn()) {
                finish();
                startActivity(new Intent(RegistrationNumber.this, NavActivity.class));
            }

            button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnteredRegNo = editText_regno.getText().toString();
                if(RegNoCheck(EnteredRegNo)){
                    sessionManager.createSession(EnteredRegNo);
                    startActivity(new Intent(RegistrationNumber.this, NavActivity.class));
                }
            }
        });
    }
//    validate the registration number
    boolean RegNoCheck(String regNo) {
//        length check
        if(regNo.length() == 9) {
            return true;
        }
        return false;
    }
}
