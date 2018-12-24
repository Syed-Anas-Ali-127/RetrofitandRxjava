package com.example.android.retrofit;

import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnclk1);
        btn1 = findViewById(R.id.btnclk2);
        final ListView listView = findViewById(R.id.listview);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                Api api = retrofit.create(Api.class);

                Call<List<GetnSet>> call = api.getDetails();

                call.enqueue(new Callback<List<GetnSet>>() {
                    @Override
                    public void onResponse(Call<List<GetnSet>> call, Response<List<GetnSet>> response) {
                        List<GetnSet> getnSets = response.body();

                        String[] getnset = new String[getnSets.size()];
                        for(int i=0; i<getnSets.size(); i++)
                        {
                            getnset[i] = getnSets.get(i).getName() + "\n" + getnSets.get(i).getFullname() +
                                    "\n" + getnSets.get(i).getRollno() + "\n" + getnSets.get(i).getPhone();
                            //getnset[i] = getnSets.get(i).getFullname();
                        }

                        listView.setAdapter(new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                getnset
                        ));

                /*for(GetnSet GS: getnSets){
                    Log.d("name", GS.getName());
                    Log.d("realname", GS.getRealname());
                    Log.d("imageurl", GS.getImageurl());
                    //Log.d("Phone", String.valueOf(GS.getPhone()));
                }*/
                    }

                    @Override
                    public void onFailure(Call<List<GetnSet>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api1.Base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                Api1 api1 = retrofit.create(Api1.class);

                Call<List<GetnSet>> call = api1.getDetails();

                call.enqueue(new Callback<List<GetnSet>>() {
                    @Override
                    public void onResponse(Call<List<GetnSet>> call, Response<List<GetnSet>> response) {
                        List<GetnSet> getnSets = response.body();

                        String[] getnset = new String[getnSets.size()];
                        for(int i=0; i<getnSets.size(); i++)
                        {
                            getnset[i] = getnSets.get(i).getName() + "\n" + getnSets.get(i).getFullname() +
                                    "\n" + getnSets.get(i).getRollno() + "\n" + getnSets.get(i).getPhone();
                            //getnset[i] = getnSets.get(i).getFullname();
                        }

                        listView.setAdapter(new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                getnset
                        ));

                /*for(GetnSet GS: getnSets){
                    Log.d("name", GS.getName());
                    Log.d("realname", GS.getRealname());
                    Log.d("imageurl", GS.getImageurl());
                    //Log.d("Phone", String.valueOf(GS.getPhone()));
                }*/
                    }

                    @Override
                    public void onFailure(Call<List<GetnSet>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
