package com.example.gilgamesh.mupy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationNumber extends AppCompatActivity {

    Button button_submit;
    EditText editText_regno;
    String EnteredRegNo;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_number);

        button_submit = (Button) findViewById(R.id.submit);
        editText_regno = (EditText) findViewById(R.id.RegNo);

        sessionManager = new SessionManager(this);

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

    public static class SessionManager
    {
        private Context _context;
        private SharedPreferences preferences;
        private SharedPreferences.Editor editor;
        public static final String PREF_NAME = "USER_INFO";
        public static final String KEY_STATUS = "STATUS";

        public static String REGNO;

        public SessionManager(Context context)
        {
            this._context = context;
            preferences = _context.getSharedPreferences(PREF_NAME, 0);
            editor = preferences.edit();
        }

        public void createSession(String regno)
        {
            editor.putBoolean(KEY_STATUS, true);
            editor.putString(REGNO, regno);
            editor.commit();
        }

        public static String getDefaults(String key, Context context) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            return preferences.getString(key, null);
        }

        public boolean isLoggedIn()
        {
            return preferences.getBoolean(KEY_STATUS, false);
        }

        public String getReg() {
                      return preferences.getString(REGNO, "DEFAULT");
        }


        public void logout()
        {
            editor.clear();
            editor.commit();
        }
    }
}
