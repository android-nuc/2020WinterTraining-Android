package com.example.ywang.wintertraining2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ywang.wintertraining2.R;
import com.example.ywang.wintertraining2.base.Fruit;

import java.util.List;

public class FruitListAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitListAdapter(Context context, int resource, List<Fruit> fruits){
        super(context,resource,fruits);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            imageView = view.findViewById(R.id.fruit_image);
            textView = view.findViewById(R.id.fruit_name);
        }
    }
}
