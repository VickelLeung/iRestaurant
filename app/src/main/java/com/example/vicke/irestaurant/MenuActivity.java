package com.example.vicke.irestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private HorizontalScrollMenuView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        firebaseAuth = FirebaseAuth.getInstance();
//        btnLogout = (Button) findViewById(R.id.btnLogout);
        menu = (HorizontalScrollMenuView) findViewById(R.id.menu);

        initMenu();

//
//        Fragment fragment = new recommendFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        fm.beginTransaction().add(R.id.fragment2, fragment).commit();


        //check if user is null, if it is then go back to login
        if(firebaseAuth.getCurrentUser() == null){

        }



//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firebaseAuth.signOut();
//                finish();
//                Intent logoutIntent = new Intent(MenuActivity.this, LoginActivity.class);
//                startActivity(logoutIntent);
//            }
//        });

    }

    private void initMenu(){
        menu.addItem("Recipees", R.drawable.ic_action_recipees);
        menu.addItem("Recommendation", R.drawable.ic_action_recommendation);
        menu.addItem("testing", R.drawable.ic_action_phone);
        menu.addItem("Group Chat", R.drawable.ic_action_chat);
        menu.addItem("Profile", R.drawable.ic_action_user);
        menu.addItem("Settings", R.drawable.ic_action_setting);
        menu.addItem("Phone", R.drawable.ic_action_phone);

//        final FragmentTransaction f = getSupportFragmentManager().beginTransaction();

        menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {

//                Fragment newCase=new NewCase();
//                FragmentTransaction transaction=getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container,newCase); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();

                if(menuItem.getText() == "Recipees") {
                    Toast.makeText(MenuActivity.this, "" + menuItem.getText(), Toast.LENGTH_SHORT).show();

                    Intent goRecipees = new Intent(MenuActivity.this, FoodListActivity.class);
                    startActivity(goRecipees);

//                    f.replace(R.id.menuActivity, new recommendFragment());
//                    f.commit();

//                    Fragment recomendFrag = new recommendFragment();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragment2, recomendFrag);
//                    transaction.addToBackStack(null);
//                    transaction.commit();



                }
//                if(menuItem.getText() == "Profile" ){
//
//                }
            }
        });

    }
}