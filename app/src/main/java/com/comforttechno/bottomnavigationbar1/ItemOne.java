package com.comforttechno.bottomnavigationbar1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class ItemOne extends Fragment {

    private FragmentActivity myContext;
    public ItemOne() {
        // Required empty public constructor
    }


    public static ItemOne newInstance()
    {
        ItemOne fragment = new ItemOne();
        return  fragment;
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Offers"));
        tabLayout.addTab(tabLayout.newTab().setText("Stores"));
        tabLayout.addTab(tabLayout.newTab().setText("MyShops"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) getView().findViewById(R.id.pager);

        final com.comforttechno.bottomnavigationbar1.Helper.PagerAdapter adapter = new com.comforttechno.bottomnavigationbar1.Helper.PagerAdapter (myContext.getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }

}
