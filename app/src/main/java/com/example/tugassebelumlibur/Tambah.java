package com.example.tugassebelumlibur;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tugassebelumlibur.helper.Buku;

public class Tambah extends AppCompatActivity implements View.OnClickListener {

    EditText title, type;
    boolean update = false;
    long id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah);
        title = findViewById(R.id.title);
        type = findViewById(R.id.type);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        id = getIntent().getLongExtra("_id", 0);
        if (id != 0) {
            update = true;
            title.setText(getIntent().getStringExtra("title"));
            type.setText(getIntent().getStringExtra("author"));
        }
    }

    @Override
    public void onClick(View v) {
        Buku helper = new Buku(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title.getText().toString().trim());
        cv.put("author", type.getText().toString().trim());

        if (update) {
            db.update("buku", cv, "_id=?",
                    new String[]{String.valueOf(id)});
        } else {
            db.insert("buku", null, cv);
        }
        db.close();
        startActivity(new Intent(Tambah.this, MainActivity.class));
        finish();
    }
}