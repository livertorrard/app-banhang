package com.example.sportwear.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sportwear.R;
import com.example.sportwear.model.Loaisanpham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisanpham> loaisanphams;
    Context context;

    public LoaispAdapter(ArrayList<Loaisanpham> loaisanphams, Context context) {
        this.loaisanphams = loaisanphams;
        this.context = context;
    }

    @Override
    public int getCount() {
        return loaisanphams.size();
    }

    @Override
    public Object getItem(int position) {
        return loaisanphams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txttenloaisp = convertView.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = convertView.findViewById(R.id.imageviewloaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

            Loaisanpham loaisanpham = (Loaisanpham) getItem(position);
            viewHolder.txttenloaisp.setText(loaisanpham.getTenloaisanpham());
            Glide.with(context).load(loaisanpham.getHinhanhloaisanpham())
                    .into(viewHolder.imgloaisp);

       return convertView ;
    }
}
