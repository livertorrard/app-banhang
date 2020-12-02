package com.example.sportwear;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sportwear.Adapter.GioHangAdapter;

import java.text.DecimalFormat;

public class GioHang extends AppCompatActivity {
    ListView lvGioHang;
    TextView txtThongBao;
    static TextView txtTongTien;
    Button btnThanhToan, btnTiepTucMuaHang;
    Toolbar toolbarGioHang;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
       addControl();
        actionToolbar();
        CheckData();
        EventUtil();
        CatchOnItemListView();
        EventButton();
    }

    private void EventButton() {
        btnTiepTucMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.gioHangArrayList.size()>0){
                    Intent intent = new Intent(getApplicationContext(),ThongTinKhachHang.class);
                    startActivity(intent);
                }else {
                    CheckInternet.ShowToast_Short(getApplicationContext(),"Giỏ hàng của bạn chưa có sản phẩm!");

                }
            }
        });
    }

    private void CatchOnItemListView() {
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GioHang.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (MainActivity.gioHangArrayList.size()<=0){
                            txtThongBao.setVisibility(View.VISIBLE);
                        }else {
                            MainActivity.gioHangArrayList.remove(position);
                            gioHangAdapter.notifyDataSetChanged();
                            EventUtil();
                            if (MainActivity.gioHangArrayList.size()<=0){
                                txtThongBao.setVisibility(View.VISIBLE);
                            }else {
                                txtThongBao.setVisibility(View.INVISIBLE);
                                gioHangAdapter.notifyDataSetChanged();
                                EventUtil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        gioHangAdapter.notifyDataSetChanged();
                        EventUtil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void EventUtil() {
        long tongtien = 0;
        for (int i=0;i<MainActivity.gioHangArrayList.size();i++){
            tongtien+=MainActivity.gioHangArrayList.get(i).getGiaSP();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongTien.setText(decimalFormat.format(tongtien)+" Đ");
    }

    private void CheckData() {
        if (MainActivity.gioHangArrayList.size()<=0){
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.INVISIBLE);
        }else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarGioHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGioHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        lvGioHang = findViewById(R.id.listviewGioHang);
        txtThongBao = findViewById(R.id.txtThongBao);
        txtTongTien = findViewById(R.id.txtGiaGioHang);
        btnThanhToan = findViewById(R.id.btnThanhToanGioHang);
        btnTiepTucMuaHang = findViewById(R.id.btnTiepTucMuaHang);
        toolbarGioHang = findViewById(R.id.toolbarGioHang);
        gioHangAdapter = new GioHangAdapter(GioHang.this,MainActivity.gioHangArrayList);
        lvGioHang.setAdapter(gioHangAdapter);

    }
}