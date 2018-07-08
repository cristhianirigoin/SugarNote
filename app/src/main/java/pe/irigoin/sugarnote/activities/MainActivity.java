package pe.irigoin.sugarnote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import pe.irigoin.sugarnote.R;
import pe.irigoin.sugarnote.adapters.NoteAdapter;
import pe.irigoin.sugarnote.models.Note;
import pe.irigoin.sugarnote.repositories.NoteRepository;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure ReciclerView
        notesList = (RecyclerView) findViewById(R.id.note_list);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));

    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NoteAdapter adapter = (NoteAdapter)notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();

    }

}
