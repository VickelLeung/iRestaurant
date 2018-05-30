package com.example.vicke.irestaurant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private FragmentTransaction fragmentTransaction;
//    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        test = (Button) findViewById(R.id.test);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mainContainer, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home fragment page...");

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch(item.getItemId())
               {
                   case R.id.drawRecipee:
                       fragmentTransaction = getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.mainContainer, new RecipeeFragment());
                       fragmentTransaction.commit();
                       getSupportActionBar().setTitle("Recipee tab");
                       drawerLayout.closeDrawers();
                       break;


               }

               return false;
           }
       });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        Toast.makeText(this, ""+item.toString(), Toast.LENGTH_SHORT).show();

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
