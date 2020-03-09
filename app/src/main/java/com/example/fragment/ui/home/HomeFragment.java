package com.example.fragment.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.DetailsActivity;
import com.example.fragment.HeroAdapter;
import com.example.fragment.HeroData;
import com.example.fragment.HeroModel;
import com.example.fragment.MainActivity;
import com.example.fragment.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private ArrayList<HeroModel> listPahlawan = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rvPahlawan = root.findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(HeroData.getHeroModel());

        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        HeroAdapter heroAdapter = new HeroAdapter(getContext());
        heroAdapter.setListHero(listPahlawan);
        rvPahlawan.setAdapter(heroAdapter);

        heroAdapter.setOnItemClickCallback(new HeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(HeroModel hero) {
                Toast.makeText(getContext(), "Memilih "+hero,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_DATA,hero);
                startActivity(intent);
            }
        });
        return root;
    }
}