package com.example.ecommecce.ui.customer;

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
import com.example.ecommecce.ui.addCusomer.AddCustomer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CsutomerFragment extends Fragment {

    private CustomerViewModel customerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        customerViewModel =
                new ViewModelProvider(this).get(CustomerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_client, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);

        FloatingActionButton add_button=root.findViewById(R.id.txtsave);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Wellcome Cusomer Ali", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getContext(), AddCustomer.class);
                startActivity(intent);
            }
        });

        customerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}