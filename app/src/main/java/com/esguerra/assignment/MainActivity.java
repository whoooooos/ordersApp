 package com.esguerra.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {
     private Spinner spinner1, spinner2;
     EditText etmessage;
     String alert1,alert2,alert3,alert4;
     private RadioGroup radiotoppingsGroup;
     private RadioButton radiotoppingsButton;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         addItemsOnSpinner2();
         addItemsOnSpinner1();
        // addListenerOnButton();
         addListenerOnSpinnerItemSelection();
     }

     public void addListenerOnSpinnerItemSelection() {
         spinner1 = (Spinner) findViewById(R.id.spinner1);
         spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
         spinner2 = (Spinner) findViewById(R.id.spinner2);
         spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());

     }
     public void addItemsOnSpinner1() {

         spinner1 = (Spinner) findViewById(R.id.spinner1);
         List<String> list1 = new ArrayList<String>();
         list1.add("Chocolate");
         list1.add("Caramel");
         list1.add("Cheese");
         ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                 R.layout.spinner_item, list1);
         dataAdapter1.setDropDownViewResource(R.layout.spinner_item);
         spinner1.setAdapter(dataAdapter1);
     }
     public void addItemsOnSpinner2() {

         spinner2 = (Spinner) findViewById(R.id.spinner2);
         List<String> list = new ArrayList<String>();
         list.add("Pearl");
         list.add("Crystal");
         list.add("Gulaman");
         ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                 R.layout.spinner_item, list);
         dataAdapter.setDropDownViewResource(R.layout.spinner_item);
         spinner2.setAdapter(dataAdapter);
     }


     public void submit(View view) {
         spinner1 = (Spinner) findViewById(R.id.spinner1);
         spinner2 = (Spinner) findViewById(R.id.spinner2);
         etmessage = findViewById(R.id.etmessage);

         radiotoppingsGroup = (RadioGroup) findViewById(R.id.radiogroupshape);
         // get selected radio button from radioGroup
         int selectedId = radiotoppingsGroup.getCheckedRadioButtonId();

         // find the radiobutton by returned id
         radiotoppingsButton = (RadioButton) findViewById(selectedId);

         alert1 = radiotoppingsButton.getText().toString();
         alert2 = spinner1.getSelectedItem().toString();
         alert3 = spinner2.getSelectedItem().toString();
         alert4 = etmessage.getText().toString();

         AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
         alertDialogBuilder.setMessage("Shape: " + alert1 + "\n" + "Flavor: " + alert2+ "\n" +
                 "Toppings: " + alert3 + "\n" + "Message: " + alert4	    );
         alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {

             }
         });
         AlertDialog alertDialog = alertDialogBuilder.create();
         alertDialog.show();
         alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
         alertDialog.getWindow().getAttributes();
         TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
         textView.setTextSize(50);
         textView.setTextColor(Color.RED);
         textView.setGravity(Gravity.CENTER);




     }


 }
