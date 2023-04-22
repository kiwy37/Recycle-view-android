package com.example.tema_1_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements recycleAdapter.ItemClickListener{
    private ArrayList<Animal> list = new ArrayList<>();
    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        buildListData();
        initRecycleView(view);
        return view;
    }

    private void initRecycleView(View view) {
        RecyclerView recyclerView= view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recycleAdapter adapter=new recycleAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
    private void buildListData(){
        for (int i=0;i<12;i++) {
            list.add(new Animal("Mistreț", "Europa"));
            list.add(new Animal("Panda", "Asia"));
            list.add(new Animal("Girafa", "Africa"));
            list.add(new Animal("Vultur", "Americi"));
            list.add(new Animal("Cangur", "Australia"));
        }
    }

    @Override
    public void onItemClick(Animal animal) {
        Fragment fragment = DetailFragment.newInstance(animal);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment,"detail_fragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}