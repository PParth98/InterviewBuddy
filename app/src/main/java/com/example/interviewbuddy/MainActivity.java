package com.example.interviewbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String sub="";
    String name="";
    Button nxtBtn;
    EditText editText;
    Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1=(Spinner) findViewById(R.id.spnIntrest);

        editText = (EditText) findViewById(R.id.editname);

        nxtBtn=(Button) findViewById(R.id.nexrbutton);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    name=editText.getText().toString();
                    editText.setVisibility(View.GONE);
                    System.out.println(name);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    spin1.setVisibility(View.VISIBLE);
                    nxtBtn.setVisibility(View.VISIBLE);
                    handled = true;
                }
                return handled;
            }
        });


        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {

                    case 0:
                        sub="Android";
                        break;
                    case 1:
                        sub="iOS";
                        break;
                    case 2:
                        sub="Angular";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences();
                SharedPreferences sharedPreferences=getSharedPreferences("SharedPref",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("intrest",sub);
                editor.commit();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                //intent.putExtra("name",name);
                //intent.putExtra("intrest",sub);
                startActivity(intent);
                finish();
            }
        });


    }


}
