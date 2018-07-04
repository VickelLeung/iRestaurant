package com.example.vicke.irestaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {

    private ArrayList<RecipeeItem> al,a2;
    private ArrayAdapter<RecipeeItem> arrayAdapter;
    private int i;


    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

//        Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.fragmentExplore);
//        fragment.getView().setBackgroundColor(Color.WHITE);

        //add the view via xml or programmatically
       final SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) rootView.findViewById(R.id.frame);

        al = new ArrayList<>();
        a2 = new ArrayList<>();

        al.add(new RecipeeItem("General Tso's chicken", "chunks of chicken that are dipped in a batter and deep-fried and seasoned with " +
                "ginger, garlic, sesame oil, scallions, and hot chili peppers.","asdas" , R.drawable.chowmein));
        al.add(new RecipeeItem("Pepper steak", "consists of sliced steak, green bell peppers, tomatoes, and white or green onions stir-fried " +
                "with salt, sugar, and soy sauce.","sdas", R.drawable.ic_action_user));
        al.add(new RecipeeItem("Chow mein", "Cantonese style chow mein contains deep-fried crunchy golden egg noodles,", "asdsa", R.drawable.ic_action_user));

//        al.add("1");
//        al.add("2");
//        al.add("3");
//        al.add("4");
//        al.add("5");
//        al.add("c++");
//        al.add("css");
//        al.add("javascript");

        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.item, R.id.helloText, al );

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");

                a2.add(al.get(0));
                al.remove(0);
                if(al.size() == 0){
                    Collections.shuffle(a2);
                    for(int i = 0; i <a2.size(); i++){
                        al.add(a2.get(i));
                        a2.remove(i);
                    }
                    Toast.makeText(getContext(), "empty"+a2.size(), Toast.LENGTH_SHORT).show();
                }

//                Collections.shuffle(al);

                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "size"+al.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
//                makeToast(MyActivity.this, "Left!");
//                al.remove(0);
//                Toast.makeText(getContext(), "swiped left!", Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onRightCardExit(Object dataObject) {
//                makeToast(MyActivity.this, "Right!");
//                int size = al.size();
//                Toast.makeText(getContext(), "size:"+size, Toast.LENGTH_SHORT).show();
                al.remove(0);
//                Toast.makeText(getContext(), "swiped right!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

                Toast.makeText(getContext(), "its empty", Toast.LENGTH_SHORT).show();

                // Ask for more data here
//                al.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter.notifyDataSetChanged();
//                Log.d("LIST", "notified");
//                i++;

            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
//                makeToast(MyActivity.this, "Clicked!");
            }
        });

        return rootView;
    }

}
