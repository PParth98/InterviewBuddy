package com.example.interviewbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtname,txtintrest,txtedit;
    String intrest="",name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtname=(TextView) findViewById(R.id.txtGreet);
        txtintrest=(TextView)findViewById(R.id.txtIntrest);
        txtedit = (TextView) findViewById(R.id.txtedit);

       /* Intent intent= getIntent();
        String name=intent.getStringExtra("name");
        String intrest=intent.getStringExtra("intrest");*/

        SharedPreferences sharedPreferences=getSharedPreferences("SharedPref",MODE_PRIVATE);
        name=sharedPreferences.getString("name","");
        intrest=sharedPreferences.getString("intrest","");
        intrest=intrest+" Developer";
        String str=txtname.getText().toString()+name;

        txtname.setText(str);
        txtintrest.setText(intrest);


    }

    public void doEdit(View view) {
        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
