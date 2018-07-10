package com.example.a17010233.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText theName;
    EditText theAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theName = findViewById(R.id.etName);
        theAge = findViewById(R.id.etAge);

        theName.requestFocus();

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!theAge.getText().toString().isEmpty()) {
            String name = theName.getText().toString();
            int age = Integer.parseInt(theAge.getText().toString());
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefEdit = pref.edit();
            prefEdit.putString("myName", name);
            prefEdit.putInt("myAge", age);
            prefEdit.commit();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String rName = pref.getString("myName", "");
        int rAge = pref.getInt("myAge", 0);

        theName.setText(rName);
        theAge.setText(String.valueOf(rAge));
    }
}
