package com.huyhuynh.applazada.adapter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.huyhuynh.applazada.R;
import com.huyhuynh.applazada.model.LoaiSanPham;
import com.huyhuynh.applazada.retrofit.APIUtils;
import com.huyhuynh.applazada.retrofit.LoaiSanPhamAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpandMenuAdapter extends BaseExpandableListAdapter {
    private List<LoaiSanPham> loaiSanPhamList;
    private Context context;
    ViewHolderMenu viewHolderMenu;

    public ExpandMenuAdapter(final List<LoaiSanPham> loaiSanPhamList, Context context) {
        this.loaiSanPhamList = loaiSanPhamList;
        this.context = context;
        LoaiSanPhamAPI loaiSanPhamAPI = APIUtils.getDataLoaiSanPham();
        for (int i = 0; i< loaiSanPhamList.size();i++){
            final int finalI = i;
            loaiSanPhamAPI.getLoaiSPByMaLoaiCha(loaiSanPhamList.get(i).getMaloaisp()).enqueue(new Callback<List<LoaiSanPham>>() {
                @Override
                public void onResponse(Call<List<LoaiSanPham>> call, Response<List<LoaiSanPham>> response) {
                    List<LoaiSanPham> loaiSanPhamCon = response.body();
                    loaiSanPhamList.get(finalI).setListLoaiSPCon(loaiSanPhamCon);
                    Log.d("ExpandMenuAdapter","Oke");
                }

                @Override
                public void onFailure(Call<List<LoaiSanPham>> call, Throwable t) {
                    Log.d("ExpandMenuAdapter","Error: "+t.toString());
                }
            });
        }

    }

    @Override
    public int getGroupCount() {
        return loaiSanPhamList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(loaiSanPhamList.get(groupPosition).getListLoaiSPCon().size() != 0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public Object getGroup(int groupPosition) {
        return loaiSanPhamList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return loaiSanPhamList.get(groupPosition).getListLoaiSPCon().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return loaiSanPhamList.get(groupPosition).getMaloaisp();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return loaiSanPhamList.get(groupPosition).getListLoaiSPCon().get(childPosition).getMaloaisp();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public class ViewHolderMenu{
        TextView txtTenLoaiSP;
        ImageView hinhMenu;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View viewGroupCha = convertView;
        if(viewGroupCha == null){
            viewHolderMenu = new ViewHolderMenu();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewGroupCha = layoutInflater.inflate(R.layout.custom_layout_loaisp_group_cha,parent,false);

            viewHolderMenu.txtTenLoaiSP = viewGroupCha.findViewById(R.id.tv_GroupCha);
            viewHolderMenu.hinhMenu = viewGroupCha.findViewById(R.id.imgMenuloaiSp);

            viewGroupCha.setTag(viewHolderMenu);
        }else{
            viewHolderMenu = (ViewHolderMenu) viewGroupCha.getTag();
        }

        viewHolderMenu.txtTenLoaiSP.setText(loaiSanPhamList.get(groupPosition).getTenloaisp());
        int demsanphamcon = 1;
        if (loaiSanPhamList.get(groupPosition).getListLoaiSPCon()!=null){
            demsanphamcon  = loaiSanPhamList.get(groupPosition).getListLoaiSPCon().size();
        } else demsanphamcon = 0;

        if(demsanphamcon > 0){
            viewHolderMenu.hinhMenu.setVisibility(View.VISIBLE);
        }else{
            viewHolderMenu.hinhMenu.setVisibility(View.INVISIBLE);
        }

        if(isExpanded){
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_remove_black_24dp);
        }else{
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_add_black_24dp);
        }

        viewGroupCha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("ExpandMenuAdapter", loaiSanPhamList.get(groupPosition).getTenloaisp()
                + "---"+loaiSanPhamList.get(groupPosition).getMaloaisp());
                return false;
            }
        });

        return viewGroupCha;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SecondExpanable secondExpanable = new SecondExpanable(context);
        ExpandMenuAdapter secondAdapter = new ExpandMenuAdapter(loaiSanPhamList.get(groupPosition).getListLoaiSPCon(),context);
        secondExpanable.setAdapter(secondAdapter);

        secondExpanable.setGroupIndicator(null);
        notifyDataSetChanged();

        return secondExpanable;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    //Tự định nghĩa
    public class SecondExpanable extends ExpandableListView{

        public SecondExpanable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;
            Log.d("size",width + " - " + height);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
