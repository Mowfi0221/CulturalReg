package com.example.culturalregistration;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    CheckBox terms;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML components with Java
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        terms = findViewById(R.id.terms);
        register = findViewById(R.id.register);

        register.setOnClickListener(v -> {

            String studentName = name.getText().toString().trim();
            String studentEmail = email.getText().toString().trim();

            if (studentName.isEmpty() || studentEmail.isEmpty()) {
                Toast.makeText(this, "Please fill all fields",
                        Toast.LENGTH_SHORT).show();
            } else if (!terms.isChecked()) {
                Toast.makeText(this, "Please accept the terms",
                        Toast.LENGTH_SHORT).show();
            } else {
                String message = "Registration Successful!\n"
                        + "Name: " + studentName
                        + "\nEmail: " + studentEmail;

                new AlertDialog.Builder(this)
                        .setTitle("Registration Confirmation")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
