package com.comforttechno.bottomnavigationbar1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Item_Four extends Fragment {


    public Item_Four() {
        // Required empty public constructor
    }


    public static Item_Four newInstance()
    {
        Item_Four fragment = new Item_Four();
        return  fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item__four, container, false);
    }

}
