package com.example.dak.hotel_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservation_form extends AppCompatActivity {
    private ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        mDrawerList.setOnItemClickListener(new SlideMenuOnClick());

        EditText editText3 = (EditText) findViewById(R.id.editText2);
        editText3.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        Button accept = (Button)findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText editText4 = (EditText)findViewById(R.id.editText4);
                if(!validateEmail(editText4.getText().toString())) {
                    editText4.setError("Nesprávný formát");
                    editText4.requestFocus();
                }
                else {
                    Toast.makeText(Reservation_form.this, "Správně zadaný email.", Toast.LENGTH_SHORT).show();
                }


               EditText editText= (EditText)findViewById(R.id.editText);
               if(validateName(editText.getText().toString())){
                   Toast.makeText(Reservation_form.this,"Zadané jméno.", Toast.LENGTH_SHORT).show();
               }
               else{
                   editText.setError("Musíte zadat jméno a příjmení.");
                   editText.requestFocus();
               }

            }
        }
        );
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                editText.setText("");
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                editText2.setText("");
                EditText editText3 = (EditText) findViewById(R.id.editText3);
                editText3.setText("");
                EditText editText4 = (EditText) findViewById(R.id.editText4);
                editText4.setText("");

                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                radioGroup.clearCheck();

                CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
                checkBox.setChecked(false);
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox2.setChecked(false);

                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
                Calendar calendar = Calendar.getInstance();
                datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                spinner.setSelection(0);

                ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
                toggleButton.setChecked(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private class SlideMenuOnClick implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            selectItem(position);
        }
    }
    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent a = new Intent(Reservation_form.this, Contact.class);
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(Reservation_form.this, Rooms.class);
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(Reservation_form.this, Reservation_form.class);
                startActivity(c);
                break;
            default:
        }
    }

    private boolean validateEmail(String email){
        String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();

    }
    private boolean validateName(String name){
        if(name==""){
            return false;
        }
        else{
            return true;
        }
    }
}

