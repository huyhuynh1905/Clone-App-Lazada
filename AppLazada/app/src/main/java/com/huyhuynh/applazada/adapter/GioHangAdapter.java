package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.GioHang;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.GioHangAPI;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder> {
    Context context;
    List<GioHang> gioHangList;

    public GioHangAdapter(Context context, List<GioHang> gioHangList) {
        this.context = context;
        this.gioHangList = gioHangList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_giohang,parent,false);
        return new GioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, final int position) {
        final GioHang gioHang = gioHangList.get(position);
        Log.d("testxem","Không null onBindViewHolder");
        if (gioHang==null){
            return;
        }
        holder.tvTensp.setText(gioHang.getTensp());
        holder.tvGiasp.setText(gioHang.getGiatien()+"");
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(gioHang.getGiatien());
        holder.tvGiasp.setText(gia+" vnđ");
        holder.tvSoLuong.setText(gioHang.getSoluong()+"");
        String url = APIUtils.urlAnh + gioHang.getHinhanh();
        Glide.with(context).load(url).into(holder.imgHinhSp);

        //Xử lí sự kiến click xoá:
        holder.imgXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaGioHang(gioHang);
            }
        });
        //Xử lí tăng giảm số lương
        holder.imgTangSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themSoLuongSanPhamGioHang(gioHang,position);
            }
        });
        holder.imgGiamSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gioHang.getSoluong()>1) {
                    giamSoLuongGioHang(gioHang, position);
                } else {
                    Toast.makeText(context,"Đây là số lượng tối thiểu, hãy chọn xoá nếu" +
                            " muốn xoá sản phẩm này khỏi giỏ hàng!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void giamSoLuongGioHang(final GioHang gioHang, final int position) {
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        final int soluong = gioHang.getSoluong();
        gioHang.setGiatien(gioHang.getGiatien()/gioHang.getSoluong());
        gioHang.setSoluong(1);
        gioHangAPI.giamSoLuongGioHang(gioHang).enqueue(new Callback<Map<String, Boolean>>() {
            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {
                Map<String,Boolean> mess = response.body();
                boolean kq = mess.get("message");
                if (kq){
                    gioHangList.get(position).setSoluong(soluong-1);
                    gioHangList.get(position).setGiatien(gioHang.getGiatien()*(soluong-1));
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context,"Không thêm được!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                Log.d("themSoLuongSanPhamGioHang","Lỗi: \n"+t.toString());
            }
        });
    }

    private void themSoLuongSanPhamGioHang(final GioHang gioHang, final int position) {
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        final int soluong = gioHang.getSoluong();
        gioHang.setGiatien(gioHang.getGiatien()/gioHang.getSoluong());
        gioHang.setSoluong(1);
        gioHangAPI.themGioHang(gioHang).enqueue(new Callback<Map<String, Boolean>>() {
            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {
                Map<String,Boolean> mess = response.body();
                boolean kq = mess.get("message");
                if (kq){
                    gioHangList.get(position).setSoluong(soluong+1);
                    gioHangList.get(position).setGiatien(gioHang.getGiatien()*(soluong+1));
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context,"Không thêm được!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                Log.d("themSoLuongSanPhamGioHang","Lỗi: \n"+t.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (gioHangList!=null){
            return gioHangList.size();
        }
        return 0;
    }
    private void xoaGioHang(final GioHang gioHang) {
        GioHangAPI gioHangAPI = APIUtils.gioHangAPI();
        gioHangAPI.xoaGioHang(gioHang).enqueue(new Callback<Map<String, Boolean>>() {
            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {
                Map<String,Boolean> mess = response.body();
                boolean kq = mess.get("message");
                if (kq){
                    Toast.makeText(context,"Xoá thành công!",Toast.LENGTH_SHORT).show();
                    gioHangList.remove(gioHang);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context,"Xoá thất bại, thử load lại trang!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                Log.d("xoaGioHang","Lỗi: \n"+t.toString());
            }
        });
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhSp, imgXoaSanPham, imgTangSoLuong, imgGiamSoLuong;
        TextView tvSoLuong, tvTensp, tvGiasp;
        CardView cardView;

        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewGh);
            imgHinhSp = itemView.findViewById(R.id.imHinhGioHang);
            imgXoaSanPham = itemView.findViewById(R.id.imXoaSanPhamGioHang);
            imgGiamSoLuong = itemView.findViewById(R.id.imGiamSoLuongSPTrongGioHang);
            imgTangSoLuong = itemView.findViewById(R.id.imTangSoLuongSPTrongGioHang);
            tvSoLuong = itemView.findViewById(R.id.txtSoLuongSanPham);
            tvGiasp = itemView.findViewById(R.id.txtGiaGioHang);
            tvTensp = itemView.findViewById(R.id.txtTieuDeGioHang);
        }
    }
}
