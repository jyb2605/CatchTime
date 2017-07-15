/*
 *    Copyright 2016 Anand Muralidhar
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.anandmuralidhar.simplearandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class SimpleARActivity extends Activity{

    private GLSurfaceView mGLView = null;
    private CameraClass mCameraObject;
    private boolean appIsExiting=false;
    private GestureClass mGestureObject;
    private SensorClass mSensorObject;
    ImageView bingoView;
    ImageView buttonView;
    static ImageView messageView;
    static Animation animTransfadeout;
    FrameLayout frameLayout;
    FrameLayout.LayoutParams layoutParams;
    static NotificationCompat.Builder builder;
    static NotificationManager mNotificationManager;

    private native void CreateObjectNative(AssetManager assetManager, String pathToInternalDir);
    private native void DeleteObjectNative();
    private native void SetCameraParamsNative(int previewWidth, int previewHeight, float cameraFOV);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AssetManager assetManager = getAssets();
        String pathToInternalDir = getFilesDir().getAbsolutePath();

        mCameraObject = new CameraClass();
        if(!mCameraObject.IsResolutionSupported()) {
            ShowExitDialog(this, getString(R.string.exit_no_resolution));
            return;
        }

        // call the native constructors to create an object
        CreateObjectNative(assetManager, pathToInternalDir);
        SetCameraParamsNative(mCameraObject.GetPreviewWidth(), mCameraObject.GetPreviewHeight(),
                mCameraObject.GetFOV());

        // layout has only two components, a GLSurfaceView and a TextView

        setContentView(R.layout.simplear_layout);

        mGLView = (MyGLSurfaceView) findViewById (R.id.gl_surface_view);
//        buttonView = (ImageView) findViewById(R.id.button);
//        bingoView = (ImageView) findViewById(R.id.bingo);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        // mGestureObject will handle touch gestures on the screen
        mGestureObject = new GestureClass(this);
        mGLView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureObject.mTapDetector.onTouchEvent(event);
                return true;
            }
        });




        mSensorObject = new SensorClass(this, mGLView);
        if(!mSensorObject.isSensorsAvailable()) {
            ShowExitDialog(this, getResources().getString(R.string.exit_no_sensor));
            appIsExiting=true;
        }

        buttonView = new ImageView(this);
        bingoView = new ImageView(this);
        messageView = new ImageView(this);


        buttonView.setBackgroundResource(R.drawable.camera_02);
        layoutParams =new FrameLayout.LayoutParams(250, 250);
        layoutParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
        layoutParams.rightMargin = 50;
        buttonView.setLayoutParams(layoutParams);
        frameLayout.addView(buttonView);

        bingoView.setBackgroundResource(R.drawable.camera_01);
        layoutParams =new FrameLayout.LayoutParams(600, 300);
        layoutParams.gravity = Gravity.END;
//        layoutParams.rightMargin = 50;
        bingoView.setLayoutParams(layoutParams);
        frameLayout.addView(bingoView);


        messageView.setBackgroundResource(R.drawable.message_01);
        layoutParams =new FrameLayout.LayoutParams(600, 300);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.rightMargin=500;
        layoutParams.bottomMargin=300;

        messageView.setLayoutParams(layoutParams);
        SimpleARActivity.messageView.setVisibility(View.INVISIBLE);
        frameLayout.addView(messageView);

        animTransfadeout = AnimationUtils.loadAnimation(SimpleARActivity.this, R.anim.fadein);


        createNotification();
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



    }


    /**
     * 노티피케이션 빌드
     * @return
     */
    NotificationCompat.Builder createNotification(){
        builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("CatchTime!")
                .setContentText("퀘스트를 완료했습니다.")
                .setSmallIcon(R.mipmap.ic_launcher/*스와이프 전 아이콘*/)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            builder.setCategory(Notification.CATEGORY_MESSAGE)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }
        return builder;
    }


    @Override
    protected void onResume() {

        super.onResume();

        if(appIsExiting) {
            return;
        }

        // Android suggests that we call onResume on GLSurfaceView
        if (mGLView != null) {
            mGLView.onResume();
        }


        if(!mSensorObject.RegisterSensors()){
            ShowExitDialog(this, getResources().getString(R.string.exit_no_reg_sensor));
            appIsExiting=true;
            return;
        }

        // initialize the camera again in case activity was paused and resumed
        mCameraObject.InitializeCamera();
        mCameraObject.StartCamera();

    }

    @Override
    protected void onPause() {

        super.onPause();

        // Android suggests that we call onPause on GLSurfaceView
        if(mGLView != null) {
            mGLView.onPause();
        }

        mSensorObject.UnregisterSensors();

        mCameraObject.StopCamera();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        // We are exiting the activity, let's delete the native objects
        DeleteObjectNative();

    }

    public void ShowExitDialog(final Activity activity, String exitMessage){
        appIsExiting = true;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(exitMessage)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        activity.finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /**
     * load libSimpleARNative.so since it has all the native functions
     */
    static {
        System.loadLibrary("SimpleARNative");
    }
}
