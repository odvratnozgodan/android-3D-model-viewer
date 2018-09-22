package org.andresoviedo.library.model3D.view;

import android.content.Context;
import android.net.Uri;
import org.andresoviedo.library.model3D.services.SceneLoader;

public interface IModelActivity {
	Uri getParamUri();

	int getParamType();

	float[] getBackgroundColor();

	SceneLoader getScene();

	ModelSurfaceView getGLView();

	void runOnUiThread(Runnable action);

	Context getApplicationContext();
}
