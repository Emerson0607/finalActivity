package com.example.finalactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public final static String SHARED_PREFS = "com.example.finalactivity.SHARED_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView = findViewById(R.id.bgContextMenu);
        registerForContextMenu(imageView);
    }
    //FOR THE CREATION OF OPTIONS MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();
                startActivity(new Intent(this, MainActivity.class));
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

  //FOR THE CREATION OF POPUP MENU Profile
  public void showPopup2(View view) {
      PopupMenu popupMenu = new PopupMenu(this, view);
      popupMenu.setOnMenuItemClickListener(this);
      popupMenu.inflate(R.menu.pop);
      popupMenu.show();
  }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Add new profile is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "View profile is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Add frame is selected!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    //FOR THE CREATION OF CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //getMenuInflater().inflate(R.menu.context, menu);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.preview:
                Toast.makeText(this, "Preview is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copy:
                Toast.makeText(this, "Copy is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.download:
                Toast.makeText(this, "Download image is selected!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}