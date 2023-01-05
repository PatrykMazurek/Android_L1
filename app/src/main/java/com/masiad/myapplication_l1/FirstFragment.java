package com.masiad.myapplication_l1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.masiad.myapplication_l1.databinding.FragmentFirstBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                stratProgressBar();
                showNumber();
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private void stratProgressBar() {
        binding.progressBar.setMax(10);
        binding.progressBar.setProgress(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++){
                    binding.progressBar.setProgress(i);
                    final int number = i;
                    binding.textviewFirst.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.textviewFirst.setText(number + "/10");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void showNumber(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i <20; i++){
            service.submit(new RandNumber(getView()));
        }
        service.shutdown();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}