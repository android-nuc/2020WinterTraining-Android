package com.example.ywang.wintertraining2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button button,listButton,recyclerButton,materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        recyclerButton = findViewById(R.id.recycler_button);
        materialButton = findViewById(R.id.material_button);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
        listButton = findViewById(R.id.list_button);
        listButton.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);
        materialButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_view:
                imageView.setImageResource(R.drawable.android_lab2);
                break;
            case R.id.list_button:
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
                break;
            case R.id.recycler_button:
                Intent intent_recycler = new Intent(MainActivity.this,FruitRecyclerActivity.class);
                startActivity(intent_recycler);
                break;
            case R.id.material_button:
                Intent intent_materil = new Intent(MainActivity.this,MaterialDesignActivity.class);
                startActivity(intent_materil);
                break;
            case R.id.button:
                //                String input = editText.getText().toString();
//                Toast.makeText(MainActivity.this,input,Toast.LENGTH_SHORT).show();
//                if (progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }

//                int progress = progressBar.getProgress();
//                progress += 10;
//                progressBar.setProgress(progress);

                //AlertDialog
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("AlertDialog的标题");
//                dialog.setMessage("AlertDialog的内容");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                dialog.show();
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Progress的内容");
                progressDialog.setTitle("Progress的标题");
                progressDialog.show();
                break;

        }
    }
}
