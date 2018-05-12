package com.example.vicke.irestaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class foodActivity extends AppCompatActivity {

    ListView lst;
    String[] foodName={"California Roll", "dragon eye"};
    String[] desc ={"a sushi made of avocado", "a sushi made out of shrimps"};
    String[] ingredients={"Rice", "shrimps"};
    Integer[] imgId = {R.drawable.foodlogo, R.drawable.foodlogo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        lst =(ListView) findViewById(R.id.listview);



    }
}
