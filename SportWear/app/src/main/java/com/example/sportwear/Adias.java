package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportwear.Adapter.AdiasAdapter;
import com.example.sportwear.model.SanPhamAdias;
import com.example.sportwear.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adias extends AppCompatActivity {

    Toolbar toolbarAdias;
    int idsanpham = 0;
    RecyclerView recyclerView;

   ArrayList<SanPhamAdias> adiasArrayList;
   AdiasAdapter adiasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adias);
        Intent intent = getIntent();
        idsanpham = intent.getIntExtra("idloaisanpham",-1);
        AnhXa();
        ActionTooBar();
        getrecyclerview();
        GetDuLieu();


    }
    private void getrecyclerview() {
        recyclerView = (RecyclerView)findViewById(R.id.recyclerviewadias);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false) ;
        recyclerView.setLayoutManager(linearLayout);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        adiasArrayList =  new ArrayList<>();
        adiasAdapter = new AdiasAdapter(Adias.this,adiasArrayList);
        recyclerView.setAdapter(adiasAdapter);
    }

      private void GetDuLieu() {
          RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
          StringRequest stringRequest = new StringRequest(Request.Method.POST,Server.Linksanpham,
                  new Response.Listener<String>() {
                      @Override
                      public void onResponse(String response) {
                          if (response != null) {
                              try {
                                  JSONArray jsonArray = new JSONArray(response);
                                  for (int i = 0; i < jsonArray.length(); i++) {
                                      JSONObject jsonObject = jsonArray.getJSONObject(i);
                                      int id = jsonObject.getInt("id");
                                      String tensp = jsonObject.getString("tensp");
                                      Integer giasp = jsonObject.getInt("giasp");
                                      String hinhanhsp = jsonObject.getString("hinhanhsp");
                                      String motasp = jsonObject.getString("motasp");
                                      int idsanpham = jsonObject.getInt("idsanpham");
                                      adiasArrayList.add(new SanPhamAdias(idsanpham,hinhanhsp, tensp, giasp,motasp));

                                  }
                                  adiasAdapter.notifyDataSetChanged();

                              } catch (JSONException e) {
                                  e.printStackTrace();
                              }
                              }}}, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
               Toast.makeText(Adias.this,error.toString(),Toast.LENGTH_SHORT).show();
              }
          }) {
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  HashMap<String, String> param = new HashMap<>();
                  param.put("idsanpham", String.valueOf(idsanpham));
                  return param;
              }
          };

          requestQueue.add(stringRequest);
      }



          private void AnhXa() {
        toolbarAdias = (Toolbar) findViewById(R.id.toolbaradias);

    }
    private  void Chitietsp()
    {

    }


    private void ActionTooBar(){
        setSupportActionBar(toolbarAdias);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarAdias.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
