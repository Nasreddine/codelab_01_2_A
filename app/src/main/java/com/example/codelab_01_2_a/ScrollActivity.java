package com.example.codelab_01_2_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class ScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        TableLayout tableLayout = findViewById(R.id.table);

        for (int index1 = 0; index1 < ((ViewGroup) tableLayout).getChildCount(); index1++) {

            TableRow row = (TableRow) tableLayout.getChildAt(index1);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    View view = ((ViewGroup) v).getChildAt(0);
                    Drawable background = view.getBackground();
                    int colorInt = ((ColorDrawable) background).getColor();

                    String color  = String.format("#%06X", (0xFFFFFF & colorInt));

                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label", color);
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(ScrollActivity.this, color + "copied!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}