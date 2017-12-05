package com.comforttechno.bottomnavigationbar1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comforttechno.bottomnavigationbar1.Helper.MyRecyclerViewAdapter;
import com.comforttechno.bottomnavigationbar1.model.DataObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    List<String> storeNames;
    List<String> tags;

    public Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }


    public void generateData()
    {
        storeNames = new ArrayList<>();
        tags = new ArrayList<>();
        storeNames = Arrays.asList(getResources().getStringArray(R.array.storesNames));
        tags = Arrays.asList(getResources().getStringArray(R.array.tags));

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        generateData();
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener( new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject(storeNames.get(index),
                    tags.get(index));
            results.add(index, obj);
        }
        return results;
    }
}
