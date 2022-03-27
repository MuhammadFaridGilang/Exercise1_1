package com.example.exercise1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    String dafuname, dafemail, dafpass, dafrepass;
    EditText reguname, regemail, regpass, regrepass;
    Button regbut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        reguname = findViewById(R.id.unamereg);
        regemail = findViewById(R.id.mailreg);
        regpass = findViewById(R.id.passreg);
        regrepass = findViewById(R.id.repassreg);
        regbut = findViewById(R.id.butreg);

        regbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dafuname = reguname.getText().toString();
                dafpass = regpass.getText().toString();
                dafemail = regemail.getText().toString();
                dafrepass = regrepass.getText().toString();

                if(dafuname.isEmpty() ||
                        dafemail.isEmpty() ||
                        dafpass.isEmpty() ||
                        dafrepass.isEmpty())
                {
                    Snackbar.make(view, "Tidak Boleh ada yang Kosong",
                            Snackbar.LENGTH_LONG).show();
                }
                else {
                    if (dafpass.equals(dafrepass))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil!!!",
                                Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);

                        Bundle bun = new Bundle();

                        bun.putString("uname", dafuname.trim());
                        bun.putString("pass", dafpass.trim());
                        bun.putString("email", dafemail.trim());
                        bun.putString("repass", dafrepass.trim());

                        i.putExtras(bun);
                        startActivity(i);
                    }
                    else{
                        Snackbar.make(view,"Password dan Repassword harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}