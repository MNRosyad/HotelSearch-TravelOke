package main.traveloke;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import main.traveloke.hotel.SearchActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText input_email;
    private EditText input_pass;
    private String email;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = findViewById(R.id.inputEmail);
        input_pass = findViewById(R.id.inputPassword);
        email = "mike@email.com";
        pass = "abc123";
    }

    private void showAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Login Gagal");
        alertDialog.setMessage("Email atau password anda salah. Tidak dapat meneruskan aktivitas \n\nmike@email.com \nabc123");

        alertDialog.setNegativeButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }

    private void verification() {
        String mail = input_email.getText().toString();
        String key = input_pass.getText().toString();

        if (mail.isEmpty()) {
            input_email.setError("Input Email tidak sesuai");
        } else if (key.isEmpty()) {
            input_pass.setError("Input password tidak sesuai");
        }
    }

    public void login(View view) {
        String mail = input_email.getText().toString();
        String key = input_pass.getText().toString();

        verification();

        if (!mail.equals(email)) {
            showAlert();
        } else if (!key.equals(pass)) {
            showAlert();
        } else {
            Intent next = new Intent(this, SearchActivity.class);
            startActivity(next);
        }
    }
}