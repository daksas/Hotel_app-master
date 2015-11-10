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

public class Rooms extends AppCompatActivity {
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

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

        public void click(View button) {
            switch(button.getId()) {
                case R.id.button4:
                    Intent intent = new Intent(this, Luxury_room.class);
                    startActivity(intent);
                    break;
                case R.id.button5:
                    Intent intent1 = new Intent(this, Basic_room.class);
                    startActivity(intent1);
                    break;
            }
        }
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            selectItem(position);
        }
    }


    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent a = new Intent(Rooms.this, Contact.class);
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(Rooms.this, Rooms.class);
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(Rooms.this, Reservation_form.class);
                startActivity(c);
                break;
            default:
        }
    }
}
