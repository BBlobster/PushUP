package com.example.ch.pushup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, img4, img5, imgCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img1 = (ImageView) findViewById(R.id.Auswahl_1);
        img2 = (ImageView) findViewById(R.id.Auswahl_2);
        img3 = (ImageView) findViewById(R.id.Auswahl_3);
        img4 = (ImageView) findViewById(R.id.Auswahl_4);
        img5 = (ImageView) findViewById(R.id.Auswahl_5);
        imgCursor = (ImageView) findViewById(R.id.Auswahl_cursor);




        imgCursor.setOnTouchListener(touchListener);
        imgCursor.setOnDragListener(dragListener);

        img1.setOnDragListener(dragListener);
        img2.setOnDragListener(dragListener);
        img3.setOnDragListener(dragListener);
        img4.setOnDragListener(dragListener);
        img5.setOnDragListener(dragListener);

        img1.setBackgroundColor(Color.RED);
        img2.setBackgroundColor(Color.YELLOW);
        img3.setBackgroundColor(Color.BLUE);
        img4.setBackgroundColor(Color.CYAN);
        img5.setBackgroundColor(Color.GREEN);

    }



    View.OnTouchListener touchListener = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowbuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowbuilder,v,0);

            return false;
        }
    };


    View.OnDragListener dragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:

                    switch (v.getId()){
                        case R.id.Auswahl_1:
                            img1.setBackgroundColor(Color.GRAY);
                            break;
                        case R.id.Auswahl_2:
                            img2.setBackgroundColor(Color.GRAY);
                            break;
                        case R.id.Auswahl_3:
                            img3.setBackgroundColor(Color.GRAY);
                            break;
                        case R.id.Auswahl_4:
                            img4.setBackgroundColor(Color.GRAY);
                            break;
                        case R.id.Auswahl_5:
                            img5.setBackgroundColor(Color.GRAY);
                            break;
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    switch (v.getId()){
                        case R.id.Auswahl_1:
                            img1.setBackgroundColor(Color.RED);
                            break;
                        case R.id.Auswahl_2:
                            img2.setBackgroundColor(Color.YELLOW);
                            break;
                        case R.id.Auswahl_3:
                            img3.setBackgroundColor(Color.BLUE);
                            break;
                        case R.id.Auswahl_4:
                            img4.setBackgroundColor(Color.CYAN);
                            break;
                        case R.id.Auswahl_5:
                            img5.setBackgroundColor(Color.GREEN);
                            break;
                    }
                    break;
                case DragEvent.ACTION_DROP:
                    break;
            }

            return true;
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
