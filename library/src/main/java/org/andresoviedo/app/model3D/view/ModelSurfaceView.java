package org.andresoviedo.app.model3D.view;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import org.andresoviedo.app.model3D.controller.TouchController;

/**
 * This is the actual opengl view. From here we can detect touch gestures for example
 * 
 * @author andresoviedo
 *
 */
public class ModelSurfaceView extends GLSurfaceView {

	private IModelActivity parent;
	private ModelRenderer mRenderer;
	private TouchController touchHandler;

	public ModelSurfaceView(IModelActivity parent) {
		super((Activity)parent);

		// parent component
		this.parent = parent;

		// Create an OpenGL ES 2.0 context.
		setEGLContextClientVersion(2);

		// This is the actual renderer of the 3D space
		mRenderer = new ModelRenderer(this);
		setRenderer(mRenderer);

		// Render the view only when there is a change in the drawing data
		// TODO: enable this?
		// setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		touchHandler = new TouchController(this, mRenderer);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return touchHandler.onTouchEvent(event);
	}

	public IModelActivity getModelActivity() {
		return parent;
	}

	public ModelRenderer getModelRenderer(){
		return mRenderer;
	}

}