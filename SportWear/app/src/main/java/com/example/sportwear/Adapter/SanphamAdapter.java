package com.example.sportwear.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportwear.Chitietsanpham;
import com.example.sportwear.MainActivity;
import com.example.sportwear.R;
import com.example.sportwear.model.Sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<Sanpham> sanphamArrayList;

    public SanphamAdapter(Context context, ArrayList<Sanpham> sanphamArrayList) {
        this.context = context;
        this.sanphamArrayList = sanphamArrayList;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sanphammoinhat,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;

    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Animation animation = new AlphaAnimation(10,0);
        animation.setDuration(700);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        holder.imgstar.startAnimation(animation);
        Sanpham sanpham = sanphamArrayList.get(position);
        holder.txttensanpham.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá: "+decimalFormat.format(sanpham.getGiasp())+ " Đ");
        Glide.with(context).load(sanpham.getHinhanhsp())
                .into(holder.imghinhsanpham);
        Animation animation1 = AnimationUtils.loadAnimation(context,R.anim.recyler_anim);
        holder.itemView.startAnimation(animation1);
    }

    @Override
    public int getItemCount() {
        return sanphamArrayList.size() ;
    }

    public  class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham,imgstar;
        public TextView txttensanpham,txtgiasanpham;
        public ItemHolder(final View itemView) {
            super(itemView);
            imgstar = itemView.findViewById(R.id.star);
            imghinhsanpham = itemView.findViewById(R.id.imageviewsanpham);
            txtgiasanpham = itemView.findViewById(R.id.textviewgiasanpham);
            txttensanpham = itemView.findViewById(R.id.textviewtensanpham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),Chitietsanpham.class);
                    intent.putExtra("thongtinsanpham2",sanphamArrayList.get(getLayoutPosition()));
                    intent.putExtra("id",2);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
