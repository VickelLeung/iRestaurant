package com.example.vicke.irestaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        ListView listView = (ListView) findViewById(R.id.list_view);

        ArrayList<Object> list = new ArrayList<>();
        list.add(new String("Chinese"));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));

        list.add(new String("European"));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));

        listView.setAdapter(new RecipeeAdapter(this, list));
    }
}
