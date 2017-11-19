package com.fame.wenli.fameproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wenli on 17-11-18.
 * 用来进行Viewpage和Tablayout的组合适配器
 */


public class ViewpageAdapter extends FragmentPagerAdapter {
    private String[] mtitles;
    private List<Fragment> mlist;

    /**
     *
     * @param fm 需要传入一个FragmentManager
     * @param titles 传入Tablayout的标题
     * @param list  传入需要加载的所有Fragment集合
     */
    public ViewpageAdapter(FragmentManager fm,String[] titles,List<Fragment> list) {
        super(fm);
        mtitles = titles;
        mlist= list;
    }

    /*
    返回当前的活动页面
     */
    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    /*
    viewpage的页面数量，这里返回的数字是多少那么就会产生多少的活动页面
     */
    @Override
    public int getCount() {
        return mlist.size();
    }
    /*
    显示标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles[position];
    }
}
