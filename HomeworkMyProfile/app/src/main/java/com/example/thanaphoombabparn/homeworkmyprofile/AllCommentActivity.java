package com.example.thanaphoombabparn.homeworkmyprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;

public class AllCommentActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("comment");

    TextView textAllComment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_comment);

        textAllComment = findViewById(R.id.textAllComment);
        textAllComment.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView textThankyou = findViewById(R.id.textThankyou);
        String newText = textThankyou.getText().toString();
        newText += "\n" + name;
        textThankyou.setText(newText);

        Button btnExit = findViewById(R.id.btnExitAllComment);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCommentActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> dataSnapshotIterator = dataSnapshot.getChildren().iterator();
                while (dataSnapshotIterator.hasNext()){
                    DataSnapshot value = dataSnapshotIterator.next();
                    Comment comment = value.getValue(Comment.class);
//                    Log.d("comment", "Value is: " + value.getValue());
                    String textAll = textAllComment.getText().toString();
                    if(comment != null){
                        textAll += (comment.getName()+"\n"+(comment.getComment()+"\n\n"));
                        textAllComment.setText(textAll);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("error", "Failed to read value.", error.toException());
            }
        });
    }
}
