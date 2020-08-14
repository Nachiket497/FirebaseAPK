package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase ;
    private DatabaseReference mDatabaseReference;
    private EditText mesg ;
    private  String str ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesg = (EditText)findViewById(R.id.message) ;
         mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        mDatabaseReference = mDatabase.getReference().child("DATA");
        str = mesg.getText().toString() ;
        mDatabaseReference.setValue("CLIENT : "+str);

        mesg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                str = mesg.getText().toString() ;
                HashMap hm = new HashMap();
                hm.put("DATA", str);
                mDatabaseReference.updateChildren(hm);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
