package com.example.tugassebelumlibur.Allfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.tugassebelumlibur.Detail;
import com.example.tugassebelumlibur.ImageAdapter;
import com.example.tugassebelumlibur.R;

public class Kedua extends Fragment {
    public static Kedua newInstance(int id) {
        Kedua fr = new Kedua();
        Bundle b = new Bundle();
        fr.setArguments(b);
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.fr_dua, container, false);
        GridView gv_sample = views.findViewById(R.id.gv_sample);
        gv_sample.setAdapter(new ImageAdapter(getContext()));

        gv_sample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Bundle b = new Bundle();

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        b.putString("buku", "mns");
                        Intent intent = new Intent(getContext(), Detail.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                    break;
                    case 1: {
                        b.putString("buku", "lsk");
                        Intent intent = new Intent(getContext(), Detail.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }
                    break;
                    case 2: {
                        b.putString("buku", "ank");
                        Intent intent = new Intent(getContext(), Detail.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }
                    break;
                    case 3: {
                        b.putString("buku", "rgg");
                        Intent intent = new Intent(getContext(), Detail.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }
                    break;

                }
            }
        });
        return views;
    }
}

