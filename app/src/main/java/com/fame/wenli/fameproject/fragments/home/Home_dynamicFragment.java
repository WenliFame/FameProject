package com.fame.wenli.fameproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.fame.wenli.fameproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 17-11-18.
 */

public class Home_dynamicFragment extends SupportFragment {
    private static final String TAG = "Home_dynamicFragment22";
    private Unbinder unbinder;
    @BindView(R.id.img)
    ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_dynamicfragment,container,false);
        unbinder=ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Toast.makeText(getContext(),"dynamic加载数据了",Toast.LENGTH_SHORT).show();
        img.setImageResource(R.drawable.test);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
