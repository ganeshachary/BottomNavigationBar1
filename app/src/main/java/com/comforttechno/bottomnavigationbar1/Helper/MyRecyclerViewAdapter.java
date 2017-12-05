package com.comforttechno.bottomnavigationbar1.Helper;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comforttechno.bottomnavigationbar1.R;
import com.comforttechno.bottomnavigationbar1.model.DataObject;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ALex on 11/22/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {


    public static String LOG_TAG = "Recycler Adapter";
    private ArrayList<DataObject> mDataset;
    private static MyClickListener myClickListener;


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getmText1());
        holder.dateTime.setText(mDataset.get(position).getmText2());
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }





    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView label , dateTime;
        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }
}
