package com.example.vicke.irestaurant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adefruandta.spinningwheel.SpinningWheelView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    private SpinningWheelView wheelView;
    private Button rotate;
    private String[] listItem;

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View rootView =  inflater.inflate(R.layout.fragment_recommend, container, false);

        wheelView = (SpinningWheelView) rootView.findViewById(R.id.wheel);
        rotate = (Button) rootView.findViewById(R.id.rotate);


        listItem = new String[] {"General Tso's chicken" };

        // Can be array string or list of object
        wheelView.setItems(R.array.food);

       wheelView.setOnRotationListener(new SpinningWheelView.OnRotationListener() {
           @Override
           public void onRotation() {
               Log.d("XXXX", "On Rotation");
           }

           @Override
           public void onStopRotation(Object item) {
               Log.d("XXXX", "On Rotation");
           }
       });

        // If true: user can rotate by touch
        // If false: user can not rotate by touch
        wheelView.setEnabled(false);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // max angle 50
                // duration 10 second
                // every 50 ms rander rotation
                wheelView.rotate(50, 3000, 50);
            }
        });




       return rootView;
    }

}
