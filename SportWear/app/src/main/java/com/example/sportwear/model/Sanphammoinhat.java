package com.example.sportwear.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportwear.Adapter.SanphamAdapter;
import com.example.sportwear.R;
import com.example.sportwear.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sanphammoinhat extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moinhat, container, false);
        recyclerView = view.findViewById(R.id.recyclerview1);
        mangsanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getContext(),mangsanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(sanphamAdapter);
        GetDuLieuSPNoiBat();
        return view;
    }
    private void GetDuLieuSPNoiBat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Linksanphammoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int id = 0;
                    String tensanpham = "";
                    Integer giasanpham =0;
                    String hinhanhsanpham ="";
                    String motasanpham = "";
                    int idsanpham = 0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tensanpham = jsonObject.getString("tensp");
                            giasanpham = jsonObject.getInt("giasp");
                            hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            motasanpham = jsonObject.getString("motasp");
                            idsanpham = jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(id,tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham));
                            sanphamAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}