package com.popland.pop.tileviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qozix.tileview.TileView;
import com.qozix.tileview.markers.MarkerLayout;

import java.util.ArrayList;

/**
 * Created by hai on 05/08/2017.
 */

public class RealMapTileViewActivity extends TileViewActivity {
    public static final double NORTH_WEST_LONGITUDE = -75.17261900652977;
    public static final double NORTH_WEST_LATITUDE = 39.9639998777094;
    public static final double SOUTH_EAST_LONGITUDE = -75.12462846235614;
    public static final double SOUTH_EAST_LATITUDE = 39.93699709962642;

    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        TileView tileView = getTileView();
        tileView.setSize(8000, 8000);

        tileView.addDetailLevel(0.125f, "map/125/%d_%d.png");
        tileView.addDetailLevel(0.250f, "map/250/%d_%d.png");
        tileView.addDetailLevel(0.5f, "map/500/%d_%d.png");
        tileView.addDetailLevel(1.000f, "map/1000/%d_%d.png");

//        tileView.defineBounds(
//                NORTH_WEST_LONGITUDE,
//                NORTH_WEST_LATITUDE,
//                SOUTH_EAST_LONGITUDE,
//                SOUTH_EAST_LATITUDE
//        );
        tileView.defineBounds(0,-18,7999,7985);// pixel-based coordinate system
        tileView.setMarkerAnchorPoints(-0.5f,-1.0f);
        tileView.setScaleLimits(0, 2);
        tileView.setScale(0.5f);
        tileView.setShouldRenderWhilePanning(true); // fast render tiles
        tileView.setMarkerTapListener(mMarkerTapListener);
        //add Markers
        for(double[] point : points){
            ImageView marker = new ImageView(this);
            marker.setImageResource(R.drawable.marker);
            marker.setTag(point);
            tileView.addMarker(marker,point[0],point[1],null,null);
        }

        //identify center point to set first look
        double x = 0;
        double y = 0;
        for(double[] point : points){
            x = x + point[0];
            y = y + point[1];
        }
        x = x / (points.size());
        y = y / (points.size());
        frameTo(x,y);
    }

    public MarkerLayout.MarkerTapListener mMarkerTapListener = new MarkerLayout.MarkerTapListener() {
        @Override
        public void onMarkerTap(View view, int x, int y) {
            SampleCallout callout = new SampleCallout(RealMapTileViewActivity.this);
            callout.setText("MAP CALLOUT","X: "+x+", Y: "+y);
            double[] point = (double[]) view.getTag();
            tileView.addCallout(callout,point[0],point[1],-0.5f,-1f);
        }
    };

    // list of predetermined points
    private ArrayList<double[]> points = new ArrayList<>();
    {
        points.add(new double[] {484,3018});
        points.add( new double[] {-75.1489070, 39.9484760} );
        points.add( new double[] {-75.1494000, 39.9487722} );
        points.add( new double[] {-75.1468350, 39.9474180} );
        points.add( new double[] {-75.1472000, 39.9482000} );
        points.add( new double[] {-75.1437980, 39.9508290} );
        points.add( new double[] {-75.1479650, 39.9523130} );
        points.add( new double[] {-75.1445500, 39.9472960} );
        points.add( new double[] {-75.1506100, 39.9490630} );
        points.add( new double[] {-75.1521278, 39.9508083} );
        points.add( new double[] {-75.1477600, 39.9475320} );
        points.add( new double[] {-75.1503800, 39.9489900} );
        points.add( new double[] {-75.1464200, 39.9482000} );
        points.add( new double[] {-75.1464850, 39.9498500} );
        points.add( new double[] {-75.1487030, 39.9524300} );
        points.add( new double[] {-75.1500167, 39.9488750} );
        points.add( new double[] {-75.1458360, 39.9479700} );
        points.add( new double[] {-75.1498222, 39.9515389} );
        points.add( new double[] {-75.1501990, 39.9498900} );
        points.add( new double[] {-75.1460060, 39.9474210} );
        points.add( new double[] {-75.1490230, 39.9533960} );
        points.add( new double[] {-75.1471980, 39.9485350} );
        points.add( new double[] {-75.1493500, 39.9490200} );
        points.add( new double[] {-75.1500910, 39.9503850} );
        points.add( new double[] {-75.1483930, 39.9485040} );
        points.add( new double[] {-75.1517260, 39.9473720} );
        points.add( new double[] {-75.1525630, 39.9471360} );
        points.add( new double[] {-75.1438400, 39.9473390} );
        points.add( new double[] {-75.1468240, 39.9495400} );
        points.add( new double[] {-75.1466410, 39.9499900} );
        points.add( new double[] {-75.1465050, 39.9501110} );
        points.add( new double[] {-75.1473460, 39.9436200} );
        points.add( new double[] {-75.1501570, 39.9480430} );
    }
}