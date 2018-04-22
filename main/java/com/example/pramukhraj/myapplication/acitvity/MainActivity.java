package com.example.pramukhraj.myapplication.acitvity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pramukhraj.myapplication.R;
import com.example.pramukhraj.myapplication.model.ContactsItem;
import com.example.pramukhraj.myapplication.model.NewRes;
import com.example.pramukhraj.myapplication.webutils.APIInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    NewRes model;
    int pos;
    ArrayList<ContactsItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ArrayList<ContactsItem>) getIntent().getSerializableExtra("model");
        pos = getIntent().getIntExtra("pos", 0);
        Toast.makeText(this, ""+list.get(pos).getName(), Toast.LENGTH_SHORT).show();

    }
}
