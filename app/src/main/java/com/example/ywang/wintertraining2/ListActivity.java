package com.example.ywang.wintertraining2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ywang.wintertraining2.adapter.FruitListAdapter;
import com.example.ywang.wintertraining2.base.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.list_view);
        initFruits();
        FruitListAdapter adapter = new FruitListAdapter(ListActivity.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(ListActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
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
