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

public class DanhMucSanPhamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<SanPham> sanPhamList;
    boolean change;

    public DanhMucSanPhamAdapter(Context context, List<SanPham> sanPhamList, boolean change) {
        this.context = context;
        this.sanPhamList = sanPhamList;
        this.change = change;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (change) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_danhmucsanpham_one, parent, false);
            return new DanhMucOneViewHolder(view);
        } else if (!change){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_danhmucsanpham_two, parent, false);
            return new DanhMucTwoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final SanPham sanPham = sanPhamList.get(position);
        if (sanPham==null){
            return;
        }
        if (change) {
            DanhMucOneViewHolder oneholder = (DanhMucOneViewHolder) holder;
            oneholder.tv_tenspone.setText(sanPham.getTensp());
            NumberFormat numberFormat = new DecimalFormat("###,###");
            String gia = numberFormat.format(sanPham.getGia());
            oneholder.tv_giaspone.setText(gia + " vnđ");
            String url = APIUtils.urlAnh + sanPham.getHinhlon();
            Glide.with(context).load(url).into(oneholder.img_hinhspone);
            oneholder.cardViewOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("sanpham",sanPham);
                    intent.putExtra("dataSanPham",bundle);
                    context.startActivity(intent);
                }
            });
        } else if (!change){
            DanhMucTwoViewHolder twoholder = (DanhMucTwoViewHolder) holder;
            twoholder.tv_tensptwo.setText(sanPham.getTensp());
            NumberFormat numberFormat = new DecimalFormat("###,###");
            String gia = numberFormat.format(sanPham.getGia());
            twoholder.tv_giasptwo.setText(gia + " vnđ");
            String url = APIUtils.urlAnh + sanPham.getHinhlon();
            Glide.with(context).load(url).into(twoholder.img_hinhsptwo);
            twoholder.cardViewTwo.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() {
        if (sanPhamList!=null){
            return sanPhamList.size();
        }
        return 0;
    }

    public class DanhMucOneViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tenspone,tv_giaspone;
        ImageView img_hinhspone;
        CardView cardViewOne;
        public DanhMucOneViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_giaspone = itemView.findViewById(R.id.tv_danhmuc_giasp_one);
            tv_tenspone = itemView.findViewById(R.id.tv_danhmuc_tensp_one);
            img_hinhspone = itemView.findViewById(R.id.img_danhmuc_hinhsp_one);
            cardViewOne = itemView.findViewById(R.id.cardview_danhmuc_one);
        }
    }
    public class DanhMucTwoViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tensptwo,tv_giasptwo;
        ImageView img_hinhsptwo;
        CardView cardViewTwo;
        public DanhMucTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_giasptwo = itemView.findViewById(R.id.tv_danhmuc_giasp_two);
            tv_tensptwo = itemView.findViewById(R.id.tv_danhmuc_tensp_two);
            img_hinhsptwo = itemView.findViewById(R.id.img_danhmuc_hinhsp_two);
            cardViewTwo = itemView.findViewById(R.id.cardview_danhmuc_two);
        }
    }
}
