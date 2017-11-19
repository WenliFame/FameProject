package com.fame.wenli.fameproject.fragments.message;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fame.wenli.fameproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 17-11-18.
 */

public class MessageFragment extends SupportFragment {
    private Unbinder unbinder;
    @BindView(R.id.messageimg)
    ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messagefragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        return  view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        img.setImageResource(R.drawable.test);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
