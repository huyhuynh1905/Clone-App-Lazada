package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.DanhGia;

import java.util.List;

public class DanhGiaAdapter extends RecyclerView.Adapter<DanhGiaAdapter.DanhGiaViewHolder> {

    Context context;
    List<DanhGia> danhGiaList;

    public DanhGiaAdapter(Context context, List<DanhGia> danhGiaList) {
        this.context = context;
        this.danhGiaList = danhGiaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layou_danhgiachitiet,parent,false);

        return new DanhGiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhGiaViewHolder holder, int position) {
        DanhGia danhGia = danhGiaList.get(position);
        if (danhGia==null){
            return;
        }
        holder.tvTieuDe.setText(danhGia.getTieude());
        holder.tvNoiDung.setText(danhGia.getNoidung());
        holder.tvDangBoi.setText(danhGia.getTenthietbi()+" - "+danhGia.getNgaydanhgia());
        holder.ratingBar.setRating(danhGia.getSosao());
    }

    @Override
    public int getItemCount() {
        if(danhGiaList!=null){
            if (danhGiaList.size()<5) {
                return danhGiaList.size();
            } else {
                return 5;
            }
        }
        return 0;
    }

    public class DanhGiaViewHolder extends RecyclerView.ViewHolder{

        TextView tvTieuDe,tvNoiDung,tvDangBoi;
        RatingBar ratingBar;

        public DanhGiaViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.rbDanhGia_custom);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDeDanhGia_custom);
            tvNoiDung = itemView.findViewById(R.id.tvNoiDungDanhGia_custom);
            tvDangBoi = itemView.findViewById(R.id.tvDuocDangBoi_custom);
        }
    }
}
