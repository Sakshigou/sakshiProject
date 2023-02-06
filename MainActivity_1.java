package com.example.cropregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText username, fname, address, email, phone, sgid, bankname, branch, account, ifsccode, landhactere, cropname, block, district;
    Button btnSignUp;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        fname = (EditText) findViewById(R.id.fname);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        sgid = (EditText) findViewById(R.id.sgid);
        bankname = (EditText) findViewById(R.id.bankname);
        branch = (EditText) findViewById(R.id.branch);
        account = (EditText) findViewById(R.id.account);
        ifsccode = (EditText) findViewById(R.id.ifsccode);
        landhactere = (EditText) findViewById(R.id.landhactere);
        cropname = (EditText) findViewById(R.id.cropname);
        block = (EditText) findViewById(R.id.block);
        district = (EditText) findViewById(R.id.district);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        MyDB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = username.getText().toString();
                String fname1 = fname.getText().toString();
                String address1 = address.getText().toString();
                String email1 = email.getText().toString();
                String phone1 = phone.getText().toString();
                String sgid1 = sgid.getText().toString();
                String bankname1 = bankname.getText().toString();
                String branch1 = branch.getText().toString();
                String account1 = account.getText().toString();
                String ifsccode1 = ifsccode.getText().toString();
                String landhactere1 = landhactere.getText().toString();
                String cropname1 = cropname.getText().toString();
                String block1 = block.getText().toString();
                String district1 = district.getText().toString();

                if (name1.equals("") || fname1.equals("") || address1.equals("") || email1.equals("") || phone1.equals("") || sgid1.equals("")
                        || bankname1.equals("") || branch1.equals("") || account1.equals("") || ifsccode1.equals("") || landhactere1.equals("")
                        || cropname1.equals("") || block1.equals("") || district1.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                {
                    boolean b = MyDB.insetUserData(name1, fname1, address1, email1, phone1, sgid1, bankname1, branch1,
                            account1, ifsccode1, landhactere1, cropname1, block1, district1);
                    if (b) {
                        Toast.makeText(MainActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            });

        }

    }





