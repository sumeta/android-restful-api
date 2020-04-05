package io.github.sumeta.android.androidrestapi.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.sumeta.android.androidrestapi.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private List<RecyclerViewModel> feedItemList;
    private Context mContext;

    private AdapterView.OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context context, List<RecyclerViewModel> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_recyclerview, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        final RecyclerViewModel jsonData = feedItemList.get(i);

        customViewHolder.textViewName.setText(jsonData.getLogin());
        customViewHolder.textViewNumber.setText(""+jsonData.getNumber());

//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onItemClickListener.onItemClick(jsonData);
//            }
//        };
        //customViewHolder.textView.setOnClickListener(listener);
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }
//
//    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewName;
        protected TextView textViewNumber;

        public CustomViewHolder(View view) {
            super(view);
            this.textViewName = view.findViewById(R.id.textViewName);
            this.textViewNumber = view.findViewById(R.id.textViewNumber);
        }
    }
}
