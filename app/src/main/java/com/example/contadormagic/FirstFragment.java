package com.example.contadormagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contadormagic.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    int lp1 = 0;
    int lp2 = 0;
    int pp1 = 0;
    int pp2 = 0;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        reset();

        if (savedInstanceState != null) {
            lp1 = savedInstanceState.getInt("lp1");
            lp2 = savedInstanceState.getInt("lp2");
            pp1 = savedInstanceState.getInt("pp1");
            pp2 = savedInstanceState.getInt("pp2");
        }


        return binding.getRoot();

    }

    private void updateCounters() {
        binding.txtCountP1.setText(lp1 + "/" + pp1);
        binding.txtCountP2.setText(lp2 + "/" + pp2);
    }

    private void reset() {
        lp1 = 20;
        lp2 = 20;
        pp1 = 0;
        pp2 = 0;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.LpP1.setOnClickListener(btn -> {
            lp1++;
            updateCounters();
        });

        binding.LlP1.setOnClickListener(btn -> {
            lp1--;
            updateCounters();
        });

        binding.LpP2.setOnClickListener(btn -> {
            lp2++;
            updateCounters();
        });

        binding.LlP2.setOnClickListener(btn -> {
            lp2--;
            updateCounters();
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}