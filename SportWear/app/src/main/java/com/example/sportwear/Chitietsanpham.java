package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sportwear.model.Giohang;
import com.example.sportwear.model.SanPhamAdias;
import com.example.sportwear.model.Sanpham;

import java.text.DecimalFormat;

public class Chitietsanpham extends AppCompatActivity {
    SanPhamAdias sanPhamAdias;
    Sanpham sanpham;
    Toolbar toolbarChiTietSanPham;
    ImageView imgChiTietSanPham;
    TextView txtTenSP, txtGiaSP, txtMoTaSP;
    Spinner spinner;
    Button btnDatMua;
    int Idpassdata =1;
    int Idpassdata2 =2;
    int id = 0;
    String tenChiTietSP = "";
    int giaChiTietSP = 0;
    String hinhAnhChiTiet = "";
    String moTaChiTiet = "";
    int idSanPham = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);

        addControl();
        actionToolbar();

        if (Idpassdata2 == getIntent().getIntExtra("id",0) ){
            getsanpham2();
        }
        if (Idpassdata == getIntent().getIntExtra("id1",0)){
            getsanpham1();
        }
        catchEventSpinner();
        catchEventButton();
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cart,menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuGioHang:
                Intent intent = new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
*/
    private void catchEventButton() {
        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.gioHangArrayList.size()>0){
                    int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists = false;
                    for(int i=0;i<MainActivity.gioHangArrayList.size();i++){
                        if (id==MainActivity.gioHangArrayList.get(i).getIdSP()){
                            MainActivity.gioHangArrayList.get(i).setSoLuong(MainActivity.gioHangArrayList.get(i).getSoLuong()+soLuong);
                            if (MainActivity.gioHangArrayList.get(i).getSoLuong()>10){
                                MainActivity.gioHangArrayList.get(i).setSoLuong(10);
                            }
                            MainActivity.gioHangArrayList.get(i).setGiaSP(MainActivity.gioHangArrayList.get(i).getSoLuong()*giaChiTietSP);
                            exists = true;
                        }
                    }
                    if (exists == false){
                        long giaMoi = soLuong * giaChiTietSP;
                        MainActivity.gioHangArrayList.add(new Giohang(id,tenChiTietSP,giaMoi,hinhAnhChiTiet,soLuong));
                    }

                }else {
                    int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long giaMoi = soLuong * giaChiTietSP;
                    MainActivity.gioHangArrayList.add(new Giohang(id,tenChiTietSP,giaMoi,hinhAnhChiTiet,soLuong));

                }
                Intent intent = new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
            }
        });
    }

    private void catchEventSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(),R.layout.text,soluong);
        spinner.setAdapter(arrayAdapter);

    }

   private void getsanpham1(){
       sanPhamAdias = (SanPhamAdias) getIntent().getSerializableExtra("thongtinsanpham1");
       id = sanPhamAdias.getIdSpadias();
       tenChiTietSP = sanPhamAdias.getTen();
       giaChiTietSP = sanPhamAdias.getGia();
       hinhAnhChiTiet = sanPhamAdias.getHinhanh();
       moTaChiTiet = sanPhamAdias.getMota();
       txtTenSP.setText(tenChiTietSP);
       DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
       txtGiaSP.setText("Giá: " + decimalFormat.format(giaChiTietSP) + " Đ");
       txtMoTaSP.setText(moTaChiTiet);
       Glide.with(getApplicationContext()).load(hinhAnhChiTiet)
               .into(imgChiTietSanPham);
   }
    private void getsanpham2(){
        sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham2");
        id = sanpham.getId();
        tenChiTietSP = sanpham.getTensp();
        giaChiTietSP = sanpham.getGiasp();
        hinhAnhChiTiet = sanpham.getHinhanhsp();
        moTaChiTiet = sanpham.getMotasp();
        txtTenSP.setText(tenChiTietSP);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGiaSP.setText("Giá: " + decimalFormat.format(giaChiTietSP) + " Đ");
        txtMoTaSP.setText(moTaChiTiet);
        Glide.with(getApplicationContext()).load(hinhAnhChiTiet)
                .into(imgChiTietSanPham);
    }
    private void actionToolbar() {
        setSupportActionBar(toolbarChiTietSanPham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTietSanPham.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        toolbarChiTietSanPham = findViewById(R.id.toolbarChiTietSanPham);
        imgChiTietSanPham = findViewById(R.id.imgSanPham);
        txtTenSP = findViewById(R.id.txtTenSanPham);
        txtGiaSP = findViewById(R.id.txtGiaSanPham);
        txtMoTaSP = findViewById(R.id.txtMoTaSanPham);
        spinner = findViewById(R.id.spinner);
        btnDatMua = findViewById(R.id.btnDatMua);
    }
}
