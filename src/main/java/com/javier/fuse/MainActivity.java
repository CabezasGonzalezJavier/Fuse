package com.javier.fuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.javier.fuse.controllers.FuseController;
import com.javier.fuse.controllers.FuseControllerFactory;
import com.javier.fuse.models.Fuse;
import com.javier.fuse.webservices.FuseResponseListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, FuseResponseListener {


    private ImageView mImageView;
    private FuseController mFuseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.activity_main_edit_text);
        mImageView = (ImageView) findViewById(R.id.activity_main_image_view);

        editText.setOnEditorActionListener(this);
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(mImageView);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        mFuseController = FuseControllerFactory.getsFuseController();
        mFuseController.request();
        return true;
    }

    @Override
    public void onSuccess(Fuse successResponse) {
        Log.d("Main","fff");
    }

    @Override
    public void onError(String errorResponse) {

    }
}
