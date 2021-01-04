package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.huyhuynh.applazada.model.ThuongHieu;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.view.DanhMucSanPhamActivity;

import java.util.List;

public class ThuongHieuLonAdapter extends RecyclerView.Adapter<ThuongHieuLonAdapter.DienTuViewHolder> {

    Context context;
    List<ThuongHieu> listThuongHieus;

    public ThuongHieuLonAdapter(Context context, List<ThuongHieu> listThuongHieus) {
        this.context = context;
        this.listThuongHieus = listThuongHieus;
    }

    public void setData(List<ThuongHieu> listThuongHieus){
        this.listThuongHieus = listThuongHieus;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DienTuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout_item_thuonghieulon,parent,false);
        return new DienTuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DienTuViewHolder holder, int position) {
        final ThuongHieu thuongHieu = listThuongHieus.get(position);
        if (thuongHieu==null){
            return;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onBindViewHolder","Nội dung: "+thuongHieu.getTenth()+" - Mã là: "+thuongHieu.getMath());
                Intent intent = new Intent(context, DanhMucSanPhamActivity.class);
                intent.putExtra("math",thuongHieu.getMath());
                intent.putExtra("tenth",thuongHieu.getTenth());
                context.startActivity(intent);
            }
        });
        holder.tv_tenth.setText(thuongHieu.getTenth());
        String url = APIUtils.urlAnh+thuongHieu.getHinhthuonghieu();
        Glide.with(context).load(url).into(holder.img_hinhthuonghieu);
    }

    @Override
    public int getItemCount() {
        if (listThuongHieus!=null){
            return listThuongHieus.size();
        }
        return 0;
    }

    public class DienTuViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tenth;
        ImageView img_hinhthuonghieu;
        CardView cardView;

        public DienTuViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tenth = itemView.findViewById(R.id.tv_item_thl);
            img_hinhthuonghieu = itemView.findViewById(R.id.img_item_thl);
            cardView = itemView.findViewById(R.id.cardViewThuongHieuLon);
        }
    }
}
