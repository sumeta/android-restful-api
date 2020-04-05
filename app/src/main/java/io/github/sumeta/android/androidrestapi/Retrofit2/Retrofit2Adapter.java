package io.github.sumeta.android.androidrestapi.Retrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.sumeta.android.androidrestapi.R;

public class Retrofit2Adapter extends BaseAdapter {

    Context mContext;
    ArrayList<Retrofit2ViewModel> data;

    public Retrofit2Adapter(Context context, ArrayList<Retrofit2ViewModel> data) {
        this.mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = mInflater.inflate(R.layout.listview_retrofit2, parent, false);

        TextView textViewSymbol = view.findViewById(R.id.textViewName);
        textViewSymbol.setText(data.get(position).getLogin());

        TextView textViewName = view.findViewById(R.id.textViewNumber);
        textViewName.setText(""+data.get(position).getNumber());

        return view;
    }
}
