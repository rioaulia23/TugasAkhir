package com.example.tugassebelumlibur.Allfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tugassebelumlibur.Login;
import com.example.tugassebelumlibur.R;
import com.example.tugassebelumlibur.helper.Pref;

public class Ketiga extends Fragment {
    public static Ketiga newInstance(int id) {
        Ketiga fr = new Ketiga();
        Bundle b = new Bundle();
        fr.setArguments(b);
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.fr_tiga, container, false);
        return views;
    }


    @Override
    public void onViewCreated(@NonNull View views, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(views, savedInstanceState);
        final Switch switchs = views.findViewById(R.id.switchs);
        switchs.setChecked(Pref.sharedIntance(getActivity()).getSplash());
        switchs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Pref.sharedIntance(getActivity()).setSplash(b);
//                  if (b) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setTitle("Menyala")
//                            .setMessage("Turn Off?").setCancelable(false)
//                            .setPositiveButton("OK Bro", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    switchs.setChecked(false);
//                                }
//                            });
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
            }
        });
        TextView textView = views.findViewById(R.id.user);
        Button btnout = views.findViewById(R.id.logout);
        String x = Pref.sharedIntance(getActivity()).getNama();
        textView.setText(x);

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Login.class);
                Pref.sharedIntance(getActivity())
                        .setStatusInput(false);
                startActivity(i);

            }
        });

    }
}
