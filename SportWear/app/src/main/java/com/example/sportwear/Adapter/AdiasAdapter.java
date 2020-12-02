package com.example.sportwear.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportwear.Adias;
import com.example.sportwear.Chitietsanpham;
import com.example.sportwear.R;
import com.example.sportwear.model.SanPhamAdias;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdiasAdapter extends RecyclerView.Adapter<AdiasAdapter.viewHolder> {
    Context context;
    ArrayList<SanPhamAdias> sanPhamAdias;

    public AdiasAdapter(Context context, ArrayList<SanPhamAdias> sanPhamAdias) {
        this.context = context;
        this.sanPhamAdias = sanPhamAdias;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_adias,parent,false);

        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glide.with(context).load(sanPhamAdias.get(position).getHinhanh())
                .into(holder.imghinh);
        holder.txtten.setText(sanPhamAdias.get(position).getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgia.setText("Giá: "+decimalFormat.format(sanPhamAdias.get(position).getGia())+ " Đ");
        holder.txtmota.setMaxLines(2);
        holder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtmota.setText(sanPhamAdias.get(position).getMota());
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.recyler_anim);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return sanPhamAdias.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imghinh;
        TextView txtten,txtgia,txtmota;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imghinh = (ImageView)itemView.findViewById(R.id.imageviewgiaadias);
            txtten  = (TextView) itemView.findViewById(R.id.textviewadias);
            txtgia  = (TextView) itemView.findViewById(R.id.textviewgiaadias);
            txtmota = (TextView)itemView.findViewById(R.id.textviewmotaadias);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Chitietsanpham.class);
                    intent.putExtra("thongtinsanpham1",sanPhamAdias.get(getLayoutPosition()));
                    intent.putExtra("id1",1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
