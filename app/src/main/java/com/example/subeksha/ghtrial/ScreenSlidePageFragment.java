package com.example.subeksha.ghtrial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Subeksha on 4/9/17.
 */

public class ScreenSlidePageFragment extends Fragment {

    @BindView(R.id.iv_place)
    ImageView ivPlace;
    Unbinder unbinder;
    @BindView(R.id.click1)
    FrameLayout click1;
    @BindView(R.id.click2)
    FrameLayout click2;

    public static ScreenSlidePageFragment getInstance(int page) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("PAGE", page);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch (getArguments().getInt("PAGE")) {
            case 0:

                ivPlace.setImageResource(R.drawable.basecamp);
                break;

            case 1:
                ivPlace.setImageResource(R.drawable.bazaar);
                break;

            case 2:
                ivPlace.setImageResource(R.drawable.namche);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.click1, R.id.click2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.click1:
                Toast.makeText(getActivity(), "Clicked1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.click2:
                Toast.makeText(getActivity(), "Clicked1", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

