package com.example.cellway_riderapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cellway_riderapp.R;
import com.example.cellway_riderapp.adapter.TodayRecyclerAdapter;
import com.example.cellway_riderapp.model.TodayItemModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomorrowFragment extends Fragment {

    public TomorrowFragment() {
        // Required empty public constructor
    }

    ArrayList<TodayItemModel> list = new ArrayList<>();
    String[] name = {"Savej Khan", "Dheeraj Mehta", "Kuldeep Narayan"};
    String[] mobile = {"9090909090", "0101010101", "3030303030"};
    String[] altMobile = {"3232323232", "1212121212", "1010101010"};
    String[] address = {"abcd, ksffks, dsklff Up Saharanpur(250090)", "abcd, ksffks, dsklff Up Saharanpur(250090)", "abcd, ksffks, dsklff Up Saharanpur(250090)"};
    String[] timeandDate = {"24-03-2020,23:19", "24-03-2020,23:20", "24-03-2020,23:21"};
    String[] brand = {"Samsung", "Apple", "mi"};
    String[] models = {"j7", "5s", "abcd"};
    String[] gb = {"32", "64", "128"};
    RecyclerView rvTomorrowData;

    TodayRecyclerAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tomorrow, container, false);
        rvTomorrowData = view.findViewById(R.id.rvTomorrowData);
        init();
  return view;
    }

    private void init() {
        for (int i=0;i<name.length;i++){
            TodayItemModel model = new TodayItemModel();
            model.setName(name[i]);
            model.setMobile(mobile[i]);
            model.setAltMobile(altMobile[i]);
            model.setAddress(address[i]);
            model.setTime_date(timeandDate[i]);
            model.setBrand(brand[i]);
            model.setModel(models[i]);
            model.setGb(gb[i]);

            list.add(model);
        }

        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        rvTomorrowData.setLayoutManager(layoutManager);
        adapter = new TodayRecyclerAdapter(getContext(),list);
        rvTomorrowData.setAdapter(adapter);
    }

}
