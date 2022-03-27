package com.example.exercise1_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnsignin;

    EditText etuname, etpassword;
    TextView spantv;
    String uname, pass;

    String tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin=findViewById(R.id.butsignin);
        etuname=findViewById(R.id.unametv);
        etpassword=findViewById(R.id.passtv);
        spantv=findViewById(R.id.lregister);
        tv = "New in My Activity? Register Now";
        SpannableString ss = new SpannableString(tv);



        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                uname = etuname.getText().toString();
                pass = etpassword.getText().toString();


                String username = bundle.getString("uname");
                String password = bundle.getString("pass");

                if (uname.isEmpty() || pass.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Username dan Password tidak boleh kosong",
                            Toast.LENGTH_LONG);
                    etuname.setError("Username tidak boleh kosong!");
                    etpassword.setError("Password tidak boleh kosong!");
                    t.show();
                }
                else{
                    if (!uname.equals(username) && pass.equals(password)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Username Salah",
                                Toast.LENGTH_LONG);
                        etuname.setError("Username tidak boleh kosong!");
                        t.show();
                    }
                    else{
                        if(uname.equals(username) && !pass.equals(password)){
                            Toast t = Toast.makeText(getApplicationContext(),
                                    "Password Salah",
                                    Toast.LENGTH_LONG);
                            etpassword.setError("Password tidak boleh kosong!");
                            t.show();


                        }
                        else{
                            if(uname.equals(username) && pass.equals(password)){
                                Toast t = Toast.makeText(getApplicationContext(),
                                        "Login Berhasil",
                                        Toast.LENGTH_LONG);
                                t.show();

                                Bundle b =new Bundle();

                                b.putString("a", uname.trim());
                                b.putString("b", pass.trim());

                                Intent i =new Intent(getApplicationContext(), MainMenuActivity.class);

                                i.putExtras(b);
                                startActivity(i);
                            }
                            else{
                                Toast t =Toast.makeText(getApplicationContext(),
                                        "Email dan Password salah",
                                        Toast.LENGTH_LONG);

                                t.show();
                            }
                        }
                    }
                }
            }
        });
        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent i = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(i);
            }
        };
        ss.setSpan(cs, 20,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spantv.setText(ss);
        spantv.setMovementMethod(LinkMovementMethod.getInstance());

    }
}