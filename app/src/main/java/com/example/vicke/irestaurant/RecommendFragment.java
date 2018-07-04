package com.example.vicke.irestaurant;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adefruandta.spinningwheel.SpinningWheelView;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment{

    private SpinningWheelView wheelView;
    private Button rotate;
    private Dialog myDialog;
    private ArrayList<String> items;

    public RecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       final View rootView =  inflater.inflate(R.layout.fragment_recommend, container, false);

        wheelView = (SpinningWheelView) rootView.findViewById(R.id.wheel);
        rotate = (Button) rootView.findViewById(R.id.rotate);

        String[] array = getContext().getResources().getStringArray(R.array.food);
       ArrayList<String> items = new ArrayList<>();

        for(int i = 0; i <10; i++){
            String randomStr = array[new Random().nextInt(array.length)];
            items.add(randomStr);
        }

        // Can be array string or list of object
        wheelView.setItems(items);

       wheelView.setOnRotationListener(new SpinningWheelView.OnRotationListener() {
           @Override
           public void onRotation() {
               Log.d("XXXX", "On Rotation");
           }

           @Override
           public void onStopRotation(Object item) {
               Log.d("XXXX", "On Rotation");
               Toast.makeText(getContext(), "obj"+item, Toast.LENGTH_SHORT).show();
               showPopup(item, rootView);
           }
       });

        // If true: user can rotate by touch
        // If false: user can not rotate by touch
        wheelView.setEnabled(false);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //make sure finish before start another rotate
                rotate.setClickable(false);
                // max angle 50
                // duration 10 second
                // every 50 ms rander rotation
                wheelView.rotate(50, 3000, 50);

            }
        });
        rotate.setClickable(true);

       return rootView;
    }


    public void showPopup(Object item, View v){

        TextView tv;
        final String foodName =  ""+item;
        Button btnNearby, btnRecommend, btnRecipee;

        myDialog = new Dialog(getContext());

        myDialog.setContentView(R.layout.custompopup);

        tv = (TextView) myDialog.findViewById(R.id.dialogFood);
        btnNearby = (Button) myDialog.findViewById(R.id.btnNearby);
        btnRecommend = (Button) myDialog.findViewById(R.id.btnRecommend);
        btnRecipee = (Button) myDialog.findViewById(R.id.btnRecipee);


        tv.setText(foodName);

        myDialog.setCanceledOnTouchOutside(false);

        //reset the recommend wheel
        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecommendFragment rc = new RecommendFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainContainer, rc,"findThisFragment")
                        .addToBackStack(null)
                        .commit();

                myDialog.dismiss();
            }
        });

        //display nearby restaurant of the food in map
        btnNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), MapsActivity.class);
                Bundle data = new Bundle();
                data.putSerializable("restaurant", foodName);

                intent.putExtras(data);
                startActivity(intent);

            }
        });


        btnRecipee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(getContext(), listDataActivity.class);
//                Bundle data = new Bundle();
//                data.putSerializable("list", list);
//                intent.putExtra("position", position);
//                intent.putExtras(data);
//                startActivity(intent);

            }
        });


        myDialog.show();

    }

}
