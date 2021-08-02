package com.example.tenantfinder;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tenantfinder.adapter.DiscoverRecylerViewAdapter;
import com.example.tenantfinder.model.DiscoverModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TenantDiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TenantDiscoverFragment extends Fragment {


    RecyclerView recyclerView;
    DiscoverRecylerViewAdapter adapter;




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TenantDiscoverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tenant_discover_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TenantDiscoverFragment newInstance(String param1, String param2) {
        TenantDiscoverFragment fragment = new TenantDiscoverFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private List<DiscoverModel> setData(){

        List<DiscoverModel>r = new ArrayList<>();

//         public DiscoverModel(String title, String price, String imageUrl) {
//            this.title = title;
//            this.price = price;
//            this.imageUrl = imageUrl;
//        }

        DiscoverModel r1 = new DiscoverModel("Mkondowe", "2000", "dfghjk");
        DiscoverModel r2 = new DiscoverModel("Daelo", "2000", "dfghjk");
        DiscoverModel r3 = new DiscoverModel("Fact", "2000", "dfghjk");
        DiscoverModel r4 = new DiscoverModel("Chisomo", "2000", "dfghjk");
        DiscoverModel r5 = new DiscoverModel("Maxy", "2000", "dfghjk");
        DiscoverModel r6 = new DiscoverModel("Jumbo", "2000", "dfghjk");
        DiscoverModel r7 = new DiscoverModel("Hule Malunga", "2000", "dfghjk");
        DiscoverModel r8 = new DiscoverModel("Simwela", "2000", "dfghjk");

        r.add(r1);
        r.add(r2);
        r.add(r3);
        r.add(r4);
        r.add(r5);
        r.add(r6);
        r.add(r7); r.add(r8);

        return  r;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant_discover_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewDiscover);
        adapter = new DiscoverRecylerViewAdapter(setData(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return  view;
    }
}