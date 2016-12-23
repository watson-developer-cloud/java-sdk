package com.ibm.watson.developer_cloud.android.library.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;

public final class GalleryHelper {

  private final String TAG = GalleryHelper.class.getName();
  public static final int PICK_IMAGE_REQUEST = 1001;

  private Activity activity;

  /**
   * Provides convenience access to device gallery
   * @param activity
   */
  public GalleryHelper(Activity activity) {
    this.activity = activity;
  }

  /**
   * Starts an activity to select a photo from the device's memory
   */
  public void dispatchGalleryIntent() {
    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    if (galleryIntent.resolveActivity(activity.getPackageManager()) != null) {
      activity.startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }
  }

  /**
   * This method returns the file of an image selected in the photo gallery. It should be called
   * within the onActivityResult method of an Activity.
   *
   * @param resultCode Result code of a previous activity
   * @param data Data returned from a previous activity
   * @return An image's file if successful, null otherwise
   */
  public File getFile(int resultCode, Intent data) {
    if(resultCode == activity.RESULT_OK) {
      Uri targetUri = data.getData();
      return new File(targetUri.getPath());
    }
    Log.e(TAG, "Result Code was not OK");
    return null;
  }

  /**
   * This method returns a bitmap of an image selected in the photo gallery. It should be called
   * within the onActivityResult method of an Activity.
   *
   * @param resultCode Result code of a previous activity
   * @param data Data returned from a previous activity
   * @return A bitmap image if successfully completed, null otherwise
   */
  public Bitmap getBitmap(int resultCode, Intent data) {
    if(resultCode == activity.RESULT_OK) {
      Uri targetUri = data.getData();
      try {
        return BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(targetUri));
      } catch (FileNotFoundException e) {
        Log.e(TAG, "File Not Found", e);
        return null;
      }
    }
    Log.e(TAG, "Result Code was not OK");
    return null;
  }
}
