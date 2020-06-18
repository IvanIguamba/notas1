package com.example.notas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class editorNotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_notas);
        EditText editText = (EditText) findViewById( R.id.editText);
        Intent intent = getIntent();
        final int noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1  ){
            editText.setText(MainActivity.notas1.get(noteId));
        }
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notas1.set(noteId,String.valueOf(s) );
                MainActivity.arrayAdapter.notifyDataSetChanged(); // con esto las notas editadas se guardar actomaticamente.
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
