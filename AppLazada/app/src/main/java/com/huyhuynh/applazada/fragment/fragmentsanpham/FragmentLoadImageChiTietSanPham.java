package com.huyhuynh.applazada.fragment.fragmentsanpham;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.huyhuynh.applazada.R;

public class FragmentLoadImageChiTietSanPham extends Fragment {

    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loadimage_chitietsanpham,container,false);
        Bundle bundle=getArguments();
        String linkHinh = bundle.getString("linkImage");
        imageView = view.findViewById(R.id.imgFagemntCtsp);
        String url = "http://192.168.1.102:8081/images"+linkHinh;
        Glide.with(getContext()).load(url).into(imageView);
        return view;
    }
}
