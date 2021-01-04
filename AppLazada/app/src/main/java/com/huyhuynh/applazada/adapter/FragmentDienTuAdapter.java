package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.DienTu;
import com.huyhuynh.applazada.model.SanPham;
import com.huyhuynh.applazada.model.ThuongHieu;

import java.util.List;

public class FragmentDienTuAdapter extends RecyclerView.Adapter<FragmentDienTuAdapter.FragmentDienTuViewHolder> {

    Context context;
    List<DienTu> dienTuList;

    public FragmentDienTuAdapter(Context context, List<DienTu> dienTuList) {
        this.context = context;
        this.dienTuList = dienTuList;
    }

    void setData(List<DienTu> dienTuList){
        this.dienTuList = dienTuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FragmentDienTuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_recycleview_dientu,parent,false);
        return new FragmentDienTuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentDienTuViewHolder holder, int position) {
        DienTu dienTu = dienTuList.get(position);
        if (dienTu==null){
            return;
        }
        List<ThuongHieu> thuongHieus = dienTu.getThuongHieuList();
        List<SanPham> sanPhams = dienTu.getSanPhamList();
        ThuongHieuLonAdapter thuongHieuLonAdapter = new ThuongHieuLonAdapter(context,thuongHieus);
        SanPhamTopAdapter sanPhamTopAdapter = new SanPhamTopAdapter(context,sanPhams);
        RecyclerView.LayoutManager layoutGridManager = new GridLayoutManager(context,3,GridLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutLinearManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.rcvDienTuThl.setLayoutManager(layoutGridManager);
        holder.rcvDienTuSp.setLayoutManager(layoutLinearManager);
        holder.rcvDienTuThl.setAdapter(thuongHieuLonAdapter);
        holder.rcvDienTuSp.setAdapter(sanPhamTopAdapter);
        if (position==0){
            holder.imgDienTuBanner.setImageResource(R.drawable.banner);
        } else if (position==1){
            holder.imgDienTuBanner.setImageResource(R.drawable.banner2);
        } else if (position==2){
            holder.imgDienTuBanner.setImageResource(R.drawable.banner3);
        }
    }

    @Override
    public int getItemCount() {
        if (dienTuList!=null){
            return dienTuList.size();
        }
        return 0;
    }

    public class FragmentDienTuViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rcvDienTuThl, rcvDienTuSp;
        ImageView imgDienTuBanner;
        TextView tvDienTuTenTop, tvDienTuTenBottom;
        public FragmentDienTuViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvDienTuSp = itemView.findViewById(R.id.recycle_DienTu_topDienThoai);
            rcvDienTuThl = itemView.findViewById(R.id.recycle_DienTu_thuongHieuLon);
            imgDienTuBanner = itemView.findViewById(R.id.img_rcv_dtu_banner);
            tvDienTuTenTop = itemView.findViewById(R.id.tv_rcv_dtu_tentop);
            tvDienTuTenBottom = itemView.findViewById(R.id.tv_rcv_dtu_tenbottom);
        }
    }
}
