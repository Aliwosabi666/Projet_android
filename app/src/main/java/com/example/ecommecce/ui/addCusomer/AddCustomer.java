package com.example.ecommecce.ui.addCusomer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommecce.R;
import com.example.ecommecce.classes.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import  com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddCustomer extends AppCompatActivity {
    EditText txtnom,txtprenom,txtadresse,txtemail,txtcoorgps;
    Button btn_save_customer;
    DatabaseReference reff;
    Client clt;
    long id_auto=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
      //  txtid=(EditText)findViewById(R.id.txtid);
        txtnom=(EditText)findViewById(R.id.txtnom);
        txtprenom=(EditText)findViewById(R.id.txtprenom);
        txtadresse=(EditText)findViewById(R.id.txtadresse);
        txtemail=(EditText)findViewById(R.id.txtemail);
        txtcoorgps=(EditText)findViewById(R.id.txtcoorgps);
        btn_save_customer=(Button) findViewById(R.id.btn_save_customer);
        clt = new Client();

        reff = FirebaseDatabase.getInstance().getReference().child("Client");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    id_auto=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_save_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // int id_client = Integer.parseInt(txtid.getText().toString().trim());
               // clt.setId_client(id_client);
                clt.setNom(txtnom.getText().toString().trim());
                clt.setPrenom(txtprenom.getText().toString().trim());
                clt.setAdresse(txtadresse.getText().toString().trim());
                clt.setEmail(txtemail.getText().toString().trim());
                clt.setCoor_gps(txtcoorgps.getText().toString().trim());

                reff.push().setValue(clt);
                reff.child(String.valueOf(id_auto+1)).setValue("clt");
                Toast.makeText(AddCustomer.this,"data inserted succesfully",Toast.LENGTH_LONG).show();


            }
        });




    }
}