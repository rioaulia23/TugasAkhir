package com.example.tugassebelumlibur;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        ImageView imgview = findViewById(R.id.imgview);
        TextView teks = findViewById(R.id.teks);

        String kota = "";
        Bundle b = getIntent().getExtras();
        if (b != null) {
            kota = b.getString("buku");
        }
        if (kota.equals("mns")) {
            imgview.setImageResource(R.drawable.manusia);
            teks.setText(R.string.mns);

        } else if (kota.equals("lsk")) {
            imgview.setImageResource(R.drawable.laskar);
            teks.setText(R.string.lsk);

        } else if (kota.equals("ank")) {
            imgview.setImageResource(R.drawable.anak);
            teks.setText(R.string.ank);

        } else if (kota.equals("rgg")) {
            imgview.setImageResource(R.drawable.ronggeng);
            teks.setText(R.string.rgg);

        } else ;
    }
}
