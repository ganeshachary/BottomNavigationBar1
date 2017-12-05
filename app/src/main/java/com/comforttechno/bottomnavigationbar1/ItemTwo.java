package com.comforttechno.bottomnavigationbar1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemTwo extends Fragment {


    public ItemTwo() {
        // Required empty public constructor
    }


    public static ItemTwo newInstance()
    {
        ItemTwo itemTwo = new ItemTwo();
        return itemTwo;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_two, container, false);
    }

}
