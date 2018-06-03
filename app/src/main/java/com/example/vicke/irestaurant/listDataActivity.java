package com.example.vicke.irestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listDataActivity extends AppCompatActivity {

    private TextView name, steps, desc;
    private ImageView img;
    private ArrayList<RecipeeItem> list;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundleObj = getIntent().getExtras();
        list = (ArrayList<RecipeeItem>)bundleObj.getSerializable("list");
        position = (int) bundleObj.getSerializable("position");

        Toast.makeText(this, ""+list.get(position), Toast.LENGTH_SHORT).show();

    name = (TextView) findViewById(R.id.listDataName);
    steps = (TextView) findViewById(R.id.listDataSteps);
    img = (ImageView) findViewById(R.id.listDataImg);
    desc = (TextView) findViewById(R.id.listDataDesc);

        Intent intent = getIntent();

        name.setText(list.get(position).getName());
        steps.setText(list.get(position).getSteps());
        img.setImageResource(list.get(position).getImg());
        desc.setText(list.get(position).getDesc());

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        Intent myIntent = new Intent(getApplicationContext(), RecipeeFragment.class);
////        startActivityForResult(myIntent, 0);
//
//        int id = item.getItemId();
//        if(id == R.id.home){
//            this.finish();
//        }
//
//        return true;
//
//    }
}
