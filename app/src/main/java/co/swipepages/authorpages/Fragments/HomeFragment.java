package co.swipepages.authorpages.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import co.swipepages.authorpages.BookAdapter;
import co.swipepages.authorpages.Books;
import co.swipepages.authorpages.Utils.Constants;
import co.swipepages.authorpages.R;


public class HomeFragment extends Fragment {

    private View rootView;
    private SliderLayout sliderLayout;
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Books> bookList;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = rootView.findViewById(R.id.imageSlider);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.THIN_WORM); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(3); //set scroll delay in seconds :
        setSliderViews();
        setGridViews();
        return rootView;

    }

    private void setGridViews() {
        bookList = new ArrayList<>();
        adapter = new BookAdapter(getContext(), bookList);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        prepareDatas();
    }

    private void prepareDatas() {
        int[] covers = new int[]{

                R.drawable.cover1,

        };

        Books a = new Books("January 2019",  covers[0]);
        bookList.add(a);


        adapter.notifyDataSetChanged();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getActivity());

            switch (i) {
                case 0:

                    sliderView.setImageUrl("http://www.dzeta.co/AP/cover%202.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("http://www.dzeta.co/AP/AD1.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("http://www.dzeta.co/AP/award.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("http://www.dzeta.co/AP/U.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getActivity(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }



}
