package com.example.firebase.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
EditText et;
    TextView tv;
    Button btn;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.et1);
        tv=(TextView)findViewById(R.id.txt1);
        btn=(Button) findViewById(R.id.btn);
    }

    public void show(View view)
    {

        String s = et.getText().toString();
        myRef.child("inputdata").setValue(s);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tv.setText((String)dataSnapshot.child("txt").getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       // myRef.setValue(tv.getText());
    }
}
