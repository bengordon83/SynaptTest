package com.synapt.synapttest.Notes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.synapt.synapttest.R;

import java.lang.ref.WeakReference;

/**
 * Created by Evan on 1/23/2018.
 */

public class AddNoteActivity extends AppCompatActivity {

    private TextInputEditText et_title, et_content;
    private NoteDatabase noteDatabase;
    private Note note;
    private boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);
        Button button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note = new Note(et_content.getText().toString(), et_title.getText().toString());
                new InsertTask(AddNoteActivity.this, note).execute();
            }
        });
    }

    private void setResult(Note note, int flag){
        setResult(flag, new Intent().putExtra("note", note));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void, Void, Boolean>{
        private WeakReference<AddNoteActivity> activityRefrence;
        private Note note;

        InsertTask(AddNoteActivity context, Note note){
            activityRefrence = new WeakReference<AddNoteActivity>(context);
            this.note = note;
        }
        @Override
        protected Boolean doInBackground(Void... objs){
            activityRefrence.get().noteDatabase.getNoteDao().insertNote(note);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean bool){
            if(bool){
                activityRefrence.get().setResult(note,1);
            }
        }
    }
}
