package com.example.lirocking.cubelivewallpaper;

import android.opengl.GLSurfaceView;

/**
 * Created by lirocking on 7/29/16.
 */
public class LessonThreeWallpaperService extends OpenGLES2WallpaperService {
    @Override
    GLSurfaceView.Renderer getNewRenderer() {
        return new LessonThreeRenderer();
    }
}
