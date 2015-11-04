package com.javier.fuse;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.javier.fuse.controllers.FuseController;
import com.javier.fuse.controllers.FuseControllerFactory;
import com.javier.fuse.modelclient.FuseClient;
import com.javier.fuse.webservices.FuseResponseListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, FuseResponseListener {

    private EditText mEditText;
    private ImageView mImageView;
    private FuseController mFuseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.activity_main_edit_text);
        mImageView = (ImageView) findViewById(R.id.activity_main_image_view);

        mEditText.setOnEditorActionListener(this);
        FuseControllerFactory.setResponseListerner(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        mFuseController = FuseControllerFactory.getsFuseController();
        mFuseController.request(mEditText.getText().toString());
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return true;
    }

    @Override
    public void onSuccess(FuseClient successResponse) {
        Log.d("Main","onSuccess");
        Picasso.with(this).load(successResponse.getLogo()).into(mImageView);
    }

    @Override
    public void onError(String errorResponse) {
        Log.d("Main", "errorResponse");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mImageView.setImageResource(android.R.color.transparent);

            }
        });

    }
}
