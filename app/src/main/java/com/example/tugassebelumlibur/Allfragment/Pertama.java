package com.example.tugassebelumlibur.Allfragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.tugassebelumlibur.R;
import com.example.tugassebelumlibur.Tambah;
import com.example.tugassebelumlibur.helper.Buku;

public class Pertama extends Fragment {

    Cursor c;
    SimpleCursorAdapter sca;

    public static Pertama newInstance(int id) {
        Pertama fr = new Pertama();
        Bundle b = new Bundle();
        fr.setArguments(b);
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.fr_satu, container, false);

        return views;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView lv = view.findViewById(R.id.lv_list);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        Buku helper = new Buku(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] datax = {"_id", "title", "author"};
        c = db.query("buku", datax,
                null,
                null,
                null,
                null,
                null);
        sca = new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_2,
                c, new String[]{"title", "author"},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(sca);
        registerForContextMenu(lv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), Tambah.class));
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.konten_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.update: {
                updateDataBuku(info.id);
            }
            break;
            case R.id.delete: {
                deleteDataBuku(info.id);
            }
            break;
            default:
        }
        return true;
    }

    public void updateDataBuku(long id) {
        Buku helper = new Buku(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor e = db.query("buku", new String[]{"title", "author"},
                "_id=?", new String[]{String.valueOf(id)},
                null, null, null);
        e.moveToFirst();
        Intent ii = new Intent(getContext(), Tambah.class);
        ii.putExtra("_id", id);
        ii.putExtra("title", e.getString(e.getColumnIndex("title")));
        ii.putExtra("author", e.getString(e.getColumnIndex("author")));
        startActivity(ii);
    }

    public void deleteDataBuku(long id) {
        Buku helper = new Buku(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete("buku", "_id=?", new String[]{String.valueOf(id)});
        Toast.makeText(getContext(), "data Dihapus", Toast.LENGTH_SHORT).show();
        Cursor x = db.query("buku", new String[]{"_id", "title", "author"},
                null, null, null, null, null);
        sca.changeCursor(x);
        sca.notifyDataSetChanged();
    }

}
