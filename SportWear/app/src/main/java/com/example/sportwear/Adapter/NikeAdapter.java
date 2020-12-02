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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportwear.Chitietsanpham;
import com.example.sportwear.Nike;
import com.example.sportwear.R;
import com.example.sportwear.model.SanPhamAdias;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class NikeAdapter extends RecyclerView.Adapter<NikeAdapter.viewHolder> {
    Context context;
    ArrayList<SanPhamAdias> sanphamnike;

    public NikeAdapter(Context context, ArrayList<SanPhamAdias> sanphamnike) {
        this.context = context;
        this.sanphamnike = sanphamnike;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_nike, parent, false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glide.with(context).load(sanphamnike.get(position).getHinhanh())
                .into(holder.imghinh);
        holder.txtten.setText(sanphamnike.get(position).getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgia.setText("Giá: " + decimalFormat.format(sanphamnike.get(position).getGia()) + " Đ");
        holder.txtmota.setMaxLines(2);
        holder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtmota.setText(sanphamnike.get(position).getMota());
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.recyler_anim);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return sanphamnike.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imghinh;
        TextView txtten, txtgia, txtmota;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imghinh = (ImageView) itemView.findViewById(R.id.imageviewnike);
            txtten = (TextView) itemView.findViewById(R.id.textviewnike);
            txtgia = (TextView) itemView.findViewById(R.id.textviewgianike);
            txtmota = (TextView) itemView.findViewById(R.id.textviewmotanike);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Chitietsanpham.class);
                    intent.putExtra("thongtinsanpham1",sanphamnike.get(getLayoutPosition()));
                    intent.putExtra("id1",1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}

