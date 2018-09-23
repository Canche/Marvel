package com.test.marvel.oxxo.marvel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.test.marvel.oxxo.marvel.R;
import com.test.marvel.oxxo.marvel.activity.ws.APIClient;
import com.test.marvel.oxxo.marvel.activity.ws.APIInterface;
import com.test.marvel.oxxo.marvel.activity.ws.response.Heroes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        apiInterface = APIClient.getRetrofit().create(APIInterface.class);
        mRecyclerView.setHasFixedSize(true);
        callMethot();
    }

    private void callMethot() {

        Call call = apiInterface.marvel("1537532061","dcc8b1b75fd547f465703d67b80aa02e","878f350e3e9d949c38ae444ed4e58a3c");

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Gson gson = new Gson();
                String stringResponse = gson.toJson(response.body());
                if (stringResponse instanceof String) {

                    Heroes HeroesResponse = gson.fromJson(stringResponse, Heroes.class);
                    Log.e("size" , HeroesResponse.getData().getResults().size()+"");
                    Log.e("List result" , HeroesResponse.getData().getResults().toString());
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Call", call.toString());
                Log.e("Throwable", t.toString());
            }
        });
    }
}
