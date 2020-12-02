package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportwear.Adapter.LoaispAdapter;
import com.example.sportwear.model.Giohang;
import com.example.sportwear.model.Loaisanpham;
import com.example.sportwear.model.Sanphammoinhat;
import com.example.sportwear.model.Sanphamnoibat;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisanpham> arrayList;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";

    public static ArrayList<Giohang> gioHangArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
            thanhhoatdong();
            getloaisanpham();
            CatchOnItemListView();
            ThemFragment();
            Thembuttontab();
        }else {
            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
            finish();
        }


    }
    private void ThemFragment() {
        Fragment fragment = new Sanphammoinhat();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
   private void Thembuttontab() {
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              int i =  tab.getPosition();
                switch (i){
                    case 0:
                        setFragmentForTab(0);
                        break;
                    case 1:
                        setFragmentForTab(1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);
        return true;
    }


        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.giohang:
                    Intent intent = new Intent(getApplicationContext(),GioHang.class);
                    startActivity(intent);
            }
            return super.onOptionsItemSelected(item);
        }
    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, Adias.class);
                            intent.putExtra("idloaisanpham",arrayList.get(i).getId());
                            Log.d("AAA",""+arrayList.get(i).getId());

                            startActivity(intent);
                        }else{
                            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, Nike.class);
                            intent.putExtra("idloaisanpham",arrayList.get(i).getId());
                            startActivity(intent);
                        }else{
                            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, LienHe.class);
                            startActivity(intent);
                        }else{
                            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(CheckInternet.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this, Thongtin.class);
                            startActivity(intent);
                        }else{
                            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }


    private void getloaisanpham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.LinkLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenloaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisp");
                            Log.d("AAA",""+hinhanhloaisp);
                            arrayList.add(new Loaisanpham(id, tenloaisp, hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                    arrayList.add(3,new Loaisanpham(0,"Liên Hệ","https://cdn0.iconfinder.com/data/icons/user-icons-2/100/user-13-512.png"));
                    arrayList.add(4,new Loaisanpham(0,"Thông Tin","https://img.icons8.com/ios-filled/50/000000/information.png"));


                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckInternet.ShowToast_Short(getApplicationContext(),error.toString());
            }
        }
    );
        requestQueue.add(jsonArrayRequest);


    }

    private void thanhhoatdong() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }}
        );

    }
    private void setFragmentForTab(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Sanphammoinhat();
                break;
            case 1:
                fragment = new Sanphamnoibat();
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }
    }

    private void Anhxa() {
        toolbar                  = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        navigationView           = (NavigationView)findViewById(R.id.navigationview);
        listViewmanhinhchinh     = (ListView)findViewById(R.id.listviewmanhinhchinh);
        drawerLayout             = (DrawerLayout)findViewById(R.id.drawerlayout);

        arrayList = new ArrayList<>();
        arrayList.add(0,new Loaisanpham(0,"Trang Chính","https://img.icons8.com/pastel-glyph/64/000000/home.png"));
        loaispAdapter = new LoaispAdapter(arrayList,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);

        if (gioHangArrayList == null){
            gioHangArrayList = new ArrayList<>();
        }else {

        }
    }
}
