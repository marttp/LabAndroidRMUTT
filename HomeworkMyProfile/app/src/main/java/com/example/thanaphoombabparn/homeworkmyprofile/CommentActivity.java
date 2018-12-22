package com.example.thanaphoombabparn.homeworkmyprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CommentActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("comment");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        final EditText editTextName = findViewById(R.id.editTextName);
        final EditText editTextComment = findViewById(R.id.editTextComment);
        Button btnSentComment = findViewById(R.id.btnSentComment);

        btnSentComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String comment = editTextComment.getText().toString();
                if(name.trim().isEmpty()){
                    Toast.makeText(CommentActivity.this,"Insert name",Toast.LENGTH_SHORT).show();
                    return;
                } else if(comment.trim().isEmpty()){
                    Toast.makeText(CommentActivity.this,"Insert your comment",Toast.LENGTH_SHORT).show();
                    return;
                }

                Comment newComment = new Comment(name, comment);
                myRef.child(name).setValue(newComment);

                Intent intent = new Intent(CommentActivity.this, AllCommentActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
