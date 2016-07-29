package com.example.lirocking.cubelivewallpaper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by lirocking on 7/29/16.
 */
public abstract class OpenGLES2WallpaperService extends GLWallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new OpenGLES2Engine();
    }

    class OpenGLES2Engine extends GLWallpaperService.GLEngine {

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            final ActivityManager activityManager =
                    (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            final ConfigurationInfo configurationInfo =
                    activityManager.getDeviceConfigurationInfo();
            final boolean supportEs2 =
                    configurationInfo.reqGlEsVersion >= 0x20000;

            if (supportEs2) {
                setEGLContextClientVersion(2);
                setPreserveEGLContextOnPause(true);
                setRenderer(getNewRenderer());
            } else {
                return;
            }
        }
    }

    abstract GLSurfaceView.Renderer getNewRenderer();
}
