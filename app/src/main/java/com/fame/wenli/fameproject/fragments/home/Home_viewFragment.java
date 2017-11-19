package com.fame.wenli.fameproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fame.wenli.fameproject.R;

import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 17-11-18.
 */

public class Home_viewFragment extends SupportFragment {
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_viewfragment,container,false);
        return view;
    }

    /*
    viewpager的懒加载，建议在同级切换下讲数据加载放到这里面
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Toast.makeText(getContext(),"view加载数据了",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
