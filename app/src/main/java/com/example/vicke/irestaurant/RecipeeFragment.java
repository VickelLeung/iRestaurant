package com.example.vicke.irestaurant;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeeFragment extends Fragment {

    private ListView listView;

    public RecipeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayList<Object> list = new ArrayList<>();

        ArrayList<String> steps;
        steps = new ArrayList<>();

        steps.add("1 - Marinate the Chicken\n2 - Make the Sauce\n3 - Cook the Chicken\n4 - Combine and Serve !");
        steps.add("1-Slice the steak into 1/2-inch thick slices across the grain.\n" +
                "2-Whisk together soy sauce, sugar, cornstarch, and ginger in a bowl until the sugar has dissolved and the mixture is smooth. Place the steak slices into the marinade, and stir until well-coated.\n" +
                "3-Heat 1 tablespoon of vegetable oil in a wok or large skillet over medium-high heat, and place 1/3 of the steak strips into the hot oil. Cook and stir until the beef is well-browned, about 3 minutes, and remove the beef from the wok to a bowl. Repeat twice more, with the remaining beef, and set the cooked beef aside.\n" +
                "4-Return all the cooked beef to the hot wok, and stir in the onion. Toss the beef and onion together until the onion begins to soften, about 2 minutes, then stir in the green pepper. Cook and stir the mixture until the pepper has turned bright green and started to become tender, about 2 minutes, then add the tomatoes, stir everything together, and serve.");
        steps.add("1-Bring a pot of water to a boil and cook the noodles according to the package directions. Drain and set aside.\n" +
                "\n" +
                "2-Heat a skillet over medium-high heat and add the peanut oil. Add the carrots, cabbage and onions and cook for 1 minute.\n3- Add the chicken broth, soy sauce and sesame oil, then toss in the noodles. Top with sliced green onions.");

        list.add(new String("Chinese"));
        list.add(new RecipeeItem("General Tso's chicken", "chunks of chicken that are dipped in a batter and deep-fried and seasoned with " +
                "ginger, garlic, sesame oil, scallions, and hot chili peppers.",steps.get(0) , R.drawable.chowmein));
        list.add(new RecipeeItem("Pepper steak", "consists of sliced steak, green bell peppers, tomatoes, and white or green onions stir-fried " +
                "with salt, sugar, and soy sauce.",steps.get(1), R.drawable.ic_action_user));
        list.add(new RecipeeItem("Chow mein", "Cantonese style chow mein contains deep-fried crunchy golden egg noodles,",steps.get(2), R.drawable.ic_action_user));
//        list.add(new RecipeeItem("Sweet & Sour pork", "Cantonese style chow mein contains deep-fried crunchy golden egg noodles,", steps[2] , R.drawable.ic_action_user));
//        list.add(new RecipeeItem("Ma po tofu", "Ma po tofu is one of the most famous dishes in Chuan Cuisine with a history of more than 100 years. Ma " +
//                "describes a spicy and hot taste which comes from pepper powder", R.drawable.ic_action_user));
//        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
//
//
//        list.add(new String("European"));
//        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
//        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));
//        list.add(new RecipeeItem("won ton", "A soup with beef dumpling wrapped", R.drawable.ic_action_user));

//        listView.setAdapter(new RecipeeAdapter(this.getContext(),list));

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(FoodListActivity.this, "clicked " + list.get(position).toString(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(getContext(), listDataActivity.class);
//                Bundle data = new Bundle();
//                data.putSerializable("list", list);
//                intent.putExtra("position", position);
//                intent.putExtras(data);
//                startActivity(intent);


//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       listView = (ListView) getView().findViewById(R.id.list_view);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipee, container, false);
    }

}
