package com.popland.pop.tileviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qozix.tileview.TileView;

public class TileViewActivity extends AppCompatActivity {
TileView tileView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tileView = new TileView(this);
        //tileView.setId(View.generateViewId());
        setContentView(tileView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tileView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tileView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tileView.destroy();
        tileView = null;
    }

    public TileView getTileView(){
        return tileView;
    }
    public void frameTo(final double x,final double y){
        getTileView().post(new Runnable() {
            @Override
            public void run() {
                getTileView().scrollToAndCenter(x,y);
            }
        });
    }
}
