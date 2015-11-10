package com.example.dak.hotel_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Luxury_room extends AppCompatActivity {
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luxury_room);

        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
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

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener{
         @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
             selectItem(position);
         }
    }
    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent a = new Intent(Luxury_room.this, Contact.class);
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(Luxury_room.this, Rooms.class);
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(Luxury_room.this, Reservation_form.class);
                startActivity(c);
                break;
            default:
        }
    }
}
