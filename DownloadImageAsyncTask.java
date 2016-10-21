//new DownloadImageAsyncTask((ImageView) view.findViewById(R.id.imageview_id_you_want_to_display)).execute(image_url_string);

public class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
	ImageView bmImage;

	public DownloadImageAsyncTask(ImageView bmImage) {
		this.bmImage = bmImage;
	}

	protected Bitmap doInBackground(String... urls) {
		String urldisplay = urls[0];
		Bitmap mIcon11 = null;
		try {
			InputStream in = new java.net.URL(urldisplay).openStream();
			mIcon11 = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}
		return mIcon11;
	}

	protected void onPostExecute(Bitmap result) {
		bmImage.setImageBitmap(result);
	}
}