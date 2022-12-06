package com.masiad.myapplication_l1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.masiad.myapplication_l1.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.lvMessageList.setAdapter(buildAdapter());

        binding.bInfoMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("param1", "Test");
                bundle.putString("param2", "wiadomość");
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_InfoMessage, bundle);
            }
        });

    }

    public ListAdapter buildAdapter(){
        List<Map<String, String>> maps = new ArrayList<>();
        for(Message m : MainActivity.messageList){
            Map<String, String> temp = new HashMap<String, String>();
            temp.put("name", m.name + " " + m.lastName);
            temp.put("title" , m.title);
            maps.add(temp);
        }
        return new SimpleAdapter(getContext(), maps,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "title"},
                new int[] {android.R.id.text1, android.R.id.text2});
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}