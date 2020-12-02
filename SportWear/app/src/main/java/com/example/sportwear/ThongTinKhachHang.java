package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThongTinKhachHang extends AppCompatActivity {

    EditText edtTenKhachHang, edtEmailKhachHang, edtSdtKhachHang;
    Button btnXacNhan,btnTroVe;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        addControl();
        ActionBar();

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (CheckInternet.haveNetworkConnection(getApplicationContext())){
            btnXacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String tenKhachHang = edtTenKhachHang.getText().toString().trim();
                    final String sdtKhachHang = edtSdtKhachHang.getText().toString().trim();
                    final String emailKhachHang = edtEmailKhachHang.getText().toString().trim();
                    if (tenKhachHang.length()>0 && sdtKhachHang.length()>0 && emailKhachHang.length()>0){
                        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Linkthongtinkhachhang, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                final String madonhang = response;
                                Log.d("madonhang",response);
                                if (Integer.parseInt(response)>0){
                                    RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                                    StringRequest stringRequest1 = new StringRequest(Request.Method.POST, Server.Linkchitietdonhang, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            if (response.equals("1")){
                                                MainActivity.gioHangArrayList.clear();
                                                CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn đã đặt hàng thành công!");
                                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(intent);
                                                CheckInternet.ShowToast_Short(getApplicationContext(),"Mời bạn tiếp tục mua hàng");
                                            }else {
                                                CheckInternet.ShowToast_Short(getApplicationContext(),"Đã xảy ra lỗi! Đặt hàng chưa thành công");
                                            }

                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {

                                        }
                                    }){
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            JSONArray jsonArray = new JSONArray();
                                            for (int i=0;i<MainActivity.gioHangArrayList.size();i++){
                                                JSONObject jsonObject = new JSONObject();
                                                try {
                                                    jsonObject.put("madonhang",madonhang);
                                                    jsonObject.put("masanpham",MainActivity.gioHangArrayList.get(i).getIdSP());
                                                    jsonObject.put("tensanpham",MainActivity.gioHangArrayList.get(i).getTenSP());
                                                    jsonObject.put("giasanpham",MainActivity.gioHangArrayList.get(i).getGiaSP());
                                                    jsonObject.put("soluongsanpham",MainActivity.gioHangArrayList.get(i).getSoLuong());
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                jsonArray.put(jsonObject);
                                            }
                                            HashMap<String,String> hashMap = new HashMap<String,String>();
                                            hashMap.put("json",jsonArray.toString());
                                            Log.d("vietnam",jsonArray.toString());
                                            return hashMap;
                                        }
                                    };
                                    requestQueue1.add(stringRequest1);
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap<String,String> hashMap = new HashMap<String,String>();
                                hashMap.put("tenkhachhang",tenKhachHang);
                                hashMap.put("sodienthoai",sdtKhachHang);
                                hashMap.put("email",emailKhachHang);
                                return hashMap;
                            }
                        };
                        requestQueue.add(stringRequest);
                    }else {
                        CheckInternet.ShowToast_Short(getApplicationContext(),"Hãy kiểm tra lại dữ liệu");
                    }

                }
            });
        }else {
            CheckInternet.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
        }


    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbarThongTinKhachHang);
        edtTenKhachHang = findViewById(R.id.edtTenKhachHang);
        edtEmailKhachHang = findViewById(R.id.edtEmailKhachHang);
        edtSdtKhachHang = findViewById(R.id.edtDienThoaiKhachHang);
        btnXacNhan = findViewById(R.id.btnXacNhanThongTinKhachHang);
        btnTroVe = findViewById(R.id.btnTroVe);

    }
    private void ActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

