package com.example.contadormagic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
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

        binding.PpP1.setOnClickListener(btn -> {
            pp1++;
            updateCounters();
        });

        binding.PlP1.setOnClickListener(btn -> {
            pp1--;
            updateCounters();
        });

        binding.PpP2.setOnClickListener(btn -> {
            pp2++;
            updateCounters();
        });

        binding.PlP2.setOnClickListener(btn -> {
            pp2--;
            updateCounters();
        });

        binding.Lp2p1.setOnClickListener(btn -> {
            lp2--;
            lp1++;
            updateCounters();
        });

        binding.Lp1p2.setOnClickListener(btn -> {
            lp1--;
            lp2++;
            updateCounters();
        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu);

            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                Log.e(null, String.valueOf(menuItem.getItemId()));

                if (menuItem.getItemId() == R.id.refresh) {
                    reset();
                    updateCounters();
                }

                return false;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
