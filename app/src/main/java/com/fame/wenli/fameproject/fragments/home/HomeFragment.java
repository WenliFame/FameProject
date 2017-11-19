package com.fame.wenli.fameproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearSmoothScroller;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fame.wenli.fameproject.R;
import com.fame.wenli.fameproject.adapter.ViewpageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 17-11-18.
 */

public class HomeFragment extends SupportFragment {
    private String[] titles={"首页","动态"};
    private List<Fragment> list;
    private Unbinder unbinder;
    private ViewpageAdapter adapter;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        list=new ArrayList<>();
        list.add(new Home_viewFragment());
        list.add(new Home_dynamicFragment());
        adapter = new ViewpageAdapter(getFragmentManager(),titles,list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return  view;
    }

}
