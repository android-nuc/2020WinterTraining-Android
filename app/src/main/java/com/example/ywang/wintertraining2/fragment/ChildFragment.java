package com.example.ywang.wintertraining2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ywang.wintertraining2.R;
import com.example.ywang.wintertraining2.adapter.FruitRecyclerAdapter;
import com.example.ywang.wintertraining2.base.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ChildFragment extends Fragment {

    private List<Fruit> fruitList = new ArrayList<>();

    public static ChildFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child,container,false);
//        Bundle bundle = getArguments();
//        TextView textView = view.findViewById(R.id.fragment_text);
//        if (bundle != null){
//            textView.setText(bundle.getString("title"));
//        }
        RecyclerView recyclerView = view.findViewById(R.id.fragment_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        initFruits();
        FruitRecyclerAdapter adapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initFruits(){
        for(int i = 0;i < 10;i ++){
            Fruit fruit_1 = new Fruit("apple",R.drawable.apple_pic);
            fruitList.add(fruit_1);
            Fruit fruit_2 = new Fruit("banana",R.drawable.banana_pic);
            fruitList.add(fruit_2);
            Fruit fruit_3 = new Fruit("cherry",R.drawable.cherry_pic);
            fruitList.add(fruit_3);
            Fruit fruit_4 = new Fruit("orange",R.drawable.orange_pic);
            fruitList.add(fruit_4);
        }
    }

}
