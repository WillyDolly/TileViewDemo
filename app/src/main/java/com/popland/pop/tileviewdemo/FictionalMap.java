package com.popland.pop.tileviewdemo;

import android.os.Bundle;

import com.qozix.tileview.TileView;

/**
 * Created by hai on 09/08/2017.
 */

public class FictionalMap extends TileViewActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TileView tileView = getTileView();
        tileView.setSize(480,3520);
        tileView.addDetailLevel(1f,"tiles/new/1000/%d_%d.png");
        tileView.addDetailLevel(0.5f,"tiles/new/500/%d_%d.png");
        tileView.addDetailLevel(0.25f,"tiles/new/250/%d_%d.png");
        tileView.addDetailLevel(0.125f,"tiles/new/125/%d_%d.png");

        tileView.setScaleLimits(0,10);
        tileView.setScale(0);
        tileView.setShouldRenderWhilePanning(true);
    }
}
