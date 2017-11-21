package com.fame.wenli.fameproject.fragments.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fame.wenli.fameproject.R;
import com.fame.wenli.fameproject.adapter.HighQualityAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 17-11-18.
 */

public class Home_viewFragment extends SupportFragment {
    @BindView(R.id.home_view_appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.home_view_header)
    LinearLayout headerLayout;
    @BindView(R.id.home_view_high_quality)
    RecyclerView highQuality;
    private boolean isHideHeaderLayout = false;
    private HighQualityAdapter adapter;
    Unbinder unbinder;
    private List<String> text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_viewfragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        highQuality.setLayoutManager(layoutManager);
        text = new ArrayList<>();
        return view;
    }

    /*
    viewpager的懒加载，建议在同级切换下讲数据加载放到这里面
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        adapter= new HighQualityAdapter(text);
        highQuality.setAdapter(adapter);
        Toast.makeText(getContext(),"view加载数据了",Toast.LENGTH_SHORT).show();
    }
    private void initText(){
        for(int i =0;i<50;i++){
            text.add("测试数据"+i);
        }
    }
    // 初始化AppBarLayout
    private void initAppBarLayout(){
        //header layout height
        final int headerHeight = getResources().getDimensionPixelOffset(R.dimen.header_height);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                verticalOffset = Math.abs(verticalOffset);
                if ( verticalOffset >= headerHeight ){
                    isHideHeaderLayout = true;
                    //当偏移量超过顶部layout的高度时，我们认为他已经完全移动出屏幕了
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppBarLayout.LayoutParams mParams = (AppBarLayout.LayoutParams) headerLayout.getLayoutParams();
                            mParams.setScrollFlags(0);
                            headerLayout.setLayoutParams(mParams);
                            headerLayout.setVisibility(View.GONE);
                        }
                    },100);
                }
            }
        });
    }

    @Override
    public boolean onBackPressedSupport() {
        //监听返回键
        if ( isHideHeaderLayout ){
            isHideHeaderLayout = false;
              /*微博的效果是，点击返回键拉出上面隐藏的view，并同时让list滚动到最顶部，
                我这里只给第一个fragment的RecyclerView增加了跳到第0个位置的操作，这里大家可以自行去编写逻辑
               */
       //     ((MainTabFragment)mainTabFragmentAdapter.getFragments().get(0)).getRvList().scrollToPosition(0);
            highQuality.scrollToPosition(0);
            headerLayout.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppBarLayout.LayoutParams mParams = (AppBarLayout.LayoutParams) headerLayout.getLayoutParams();
                    mParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL|                            AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                    headerLayout.setLayoutParams(mParams);
                }
            },300);
        }else {
            //如果不需要拉出顶部的header，直接关闭当前的界面
           // finish();
        }
        return true;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
