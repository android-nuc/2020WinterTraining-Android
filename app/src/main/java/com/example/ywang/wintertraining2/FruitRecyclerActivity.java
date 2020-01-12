package com.example.ywang.wintertraining2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ywang.wintertraining2.adapter.FruitRecyclerAdapter;
import com.example.ywang.wintertraining2.base.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRecyclerActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_recycler);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        initFruits();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        FruitRecyclerAdapter adapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(adapter);
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
