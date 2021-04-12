package com.example.ecommecce.ui.opportunite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecommecce.R;
import com.example.ecommecce.ui.addopportunite.Addopportunite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OpportuniteFragment extends Fragment {

    private OpportuniteViewModel opportuniteViewModel;
    FloatingActionButton add_opper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opportuniteViewModel =
                new ViewModelProvider(this).get(OpportuniteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_opportunite, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        add_opper = root.findViewById(R.id.add_opportuite);
        add_opper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Button is run",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getContext(), Addopportunite.class);
                startActivity(intent);
            }
        });
        opportuniteViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}