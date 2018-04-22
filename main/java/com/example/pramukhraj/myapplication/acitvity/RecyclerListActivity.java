package com.example.pramukhraj.myapplication.acitvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pramukhraj.myapplication.R;
import com.example.pramukhraj.myapplication.adapter.Adapter;
import com.example.pramukhraj.myapplication.model.ContactsItem;
import com.example.pramukhraj.myapplication.model.NewRes;
import com.example.pramukhraj.myapplication.webutils.APIClient;
import com.example.pramukhraj.myapplication.webutils.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;

public class RecyclerListActivity extends AppCompatActivity implements View.OnClickListener {
    APIInterface apiInterface;
    Button btn_load;
    TextView tv_res;
    RecyclerView rcv_main;
    Adapter adapter;
    ArrayList<NewRes> newRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_json_parsaing);
        btn_load = (Button) findViewById(R.id.btn_load);
        tv_res = (TextView) findViewById(R.id.tv_res);
        rcv_main = (RecyclerView) findViewById(R.id.rcv_main);

        btn_load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load:
                apiInterface = APIClient.getClient().create(APIInterface.class);
                Call<NewRes> call = apiInterface.jsonloeded();
                call.enqueue(new Callback<NewRes>() {
                    @Override
                    public void onResponse(Call<NewRes> call, retrofit2.Response<NewRes> response) {
                        Log.e("TAG", "onResponse: " + response.body().toString());
                        newRes = new ArrayList<NewRes>();
                        for (int i = 0; i < response.body().getContacts().size(); i++) {
                            NewRes model = response.body();
                            newRes.add(model);
                        }
                        rcv_main.setLayoutManager(new LinearLayoutManager(RecyclerListActivity.this));
                        adapter = new Adapter(newRes, RecyclerListActivity.this, new OnClickRecycleItem() {
                            @Override
                            public void resultclick(List<ContactsItem> newRes, int position) {
                                try {
                                    ArrayList<ContactsItem> list = (ArrayList) newRes;
//                                    Toast.makeText(RecyclerListActivity.this, "" + newRes.get(position).getName(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RecyclerListActivity.this, MainActivity.class).putExtra("model", list).putExtra("pos", position));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        });
                        rcv_main.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<NewRes> call, Throwable t) {

                    }
                });


                break;
        }
    }
}

