package com.popland.pop.tileviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qozix.tileview.TileView;
import com.qozix.tileview.markers.MarkerLayout;

/**
 * Created by hai on 04/08/2017.
 */

public class LargeImageTileViewActivity extends TileViewActivity {

    public void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
        TileView tileView = getTileView();
        //set original Image's size to tileView
        tileView.setSize(2835,4289);

        //set double-tap times, default: 0-1, max>1: zoom in further than the most detailed level
        tileView.setScaleLimits(0,3);
        //from most detailed -> least detailed
        tileView.addDetailLevel(1.000f,"tiles/painting/1000/%d_%d.jpg");
        tileView.addDetailLevel(0.500f,"tiles/painting/500/%d_%d.jpg");
        tileView.addDetailLevel(0.250f,"tiles/painting/250/%d_%d.jpg");
        tileView.addDetailLevel(0.125f,"tiles/painting/125/%d_%d.jpg");
        //set initialScale(very first look) within ScaleLimits
        tileView.setScale(0);

        //establish relative coordinate system(other than pixels) for positioning methods
        tileView.defineBounds(0,0,1,1);
        frameTo(0.5,0.5);

        //create effect when panning
        tileView.setShouldRenderWhilePanning(true);
        //disable double-tap at max scale
        tileView.setShouldLoopScale(false);
        //anchor marker's image to a point which should be at the center of the image's bottom edge
        tileView.setMarkerAnchorPoints(-0.5f,-1f);
        tileView.setMarkerTapListener(mMarkerTapListener);
        addMarkers(R.drawable.marker,0.5,0.5);
        addMarkers(R.mipmap.ic_launcher,0.5,0.5);
        addMarkers(R.drawable.marker,0.25,0.75);
    }

    public void addMarkers(int icon,double x,double y){
        ImageView marker = new ImageView(LargeImageTileViewActivity.this);
        marker.setImageResource(icon);
        tileView.addMarker(marker,x,y,null,null);
    }

    public MarkerLayout.MarkerTapListener mMarkerTapListener = new MarkerLayout.MarkerTapListener() {
        @Override
        public void onMarkerTap(View view, int x, int y) {
            Toast.makeText(getApplicationContext(),"x: "+x+"- y: "+y,Toast.LENGTH_SHORT).show();
        }
    };
}
