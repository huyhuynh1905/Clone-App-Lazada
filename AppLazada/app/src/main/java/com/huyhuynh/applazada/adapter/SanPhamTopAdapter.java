package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.view.ChiTietSanPhamActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class SanPhamTopAdapter extends RecyclerView.Adapter<SanPhamTopAdapter.SanPhamTopViewHolder> {
    Context context;
    List<SanPham> sanPhamList;

    public SanPhamTopAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public SanPhamTopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_item_topdienthoai,parent,false);

        return new SanPhamTopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamTopViewHolder holder, int position) {
        final SanPham sanPham = sanPhamList.get(position);
        if (sanPham == null){
            return;
        }
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGia());
        holder.tvTensptop.setText(sanPham.getTensp());
        holder.tvGiasptop.setText(gia+" vnđ");
        holder.tvGiamgia.setText("");
        String url = APIUtils.urlAnh+sanPham.getHinhlon();
        Glide.with(context).load(url).into(holder.imgAnhSp);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("sanpham",sanPham);
                intent.putExtra("dataSanPham",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (sanPhamList!=null){
            return sanPhamList.size();
        }
        return 0;
    }

    public class SanPhamTopViewHolder extends RecyclerView.ViewHolder {

        TextView tvTensptop,tvGiasptop,tvGiamgia;
        ImageView imgAnhSp;
        CardView cardView;
        public SanPhamTopViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTensptop = itemView.findViewById(R.id.tv_item_topdt_tensp);
            tvGiasptop = itemView.findViewById(R.id.tv_item_topdt_gia);
            tvGiamgia = itemView.findViewById(R.id.tv_item_topdt_giamgia);
            imgAnhSp = itemView.findViewById(R.id.img_item_topdt);
            cardView = itemView.findViewById(R.id.cardViewTopDienThoai);
        }
    }
}
