package com.example.vicke.irestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeeAdapter extends BaseAdapter{

    ArrayList<Object> list;
    private static final int recipeeItem = 0;
    private static final int header = 1;
    private LayoutInflater inflater;

    //ctor
    public RecipeeAdapter(Context context, ArrayList<Object> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {

        //check if it is an instance of RecipeeItem
        if(list.get(position) instanceof RecipeeItem)
            return recipeeItem;
        //if not instance then must be header
        else
            return header;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //will set the view and return it
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            switch(getItemViewType(position)){
                case recipeeItem:
                    view = inflater.inflate(R.layout.item_listview,null);
                    break;
                case header:
                    view = inflater.inflate(R.layout.item_listview_header,null);
                    break;
            }
        }
        switch(getItemViewType(position)){
            case recipeeItem:
               ImageView image = (ImageView) view.findViewById(R.id.itemListViewImg);
                TextView name = (TextView) view.findViewById(R.id.itemlistviewName);
                TextView desc = (TextView) view.findViewById(R.id.itemlistviewDesc);

                image.setImageResource(((RecipeeItem)list.get(position)).getImg());
                name.setText(((RecipeeItem)list.get(position)).getName());
                desc.setText(((RecipeeItem) list.get(position)).getDesc());
                break;
            case header:

                TextView title = (TextView) view.findViewById(R.id.itemListViewHeader);
                title.setText((String)list.get(position));
                break;
        }
        return view;
    }
}
