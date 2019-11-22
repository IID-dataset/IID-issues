Triggering condition: handling a lot of images
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onReceive(Context context, Intent intent) {
new AppWidgetUpdateTask(context) {}.execute();
protected Boolean doInBackground(Void... params) {
ComponentName widget = new ComponentName(mContext, MuzeiAppWidgetProvider.class);
AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
Uri imageUri = ContentUris.withAppendedId(MuzeiContract.Artwork.CONTENT_URI,artwork.getLong(artwork.getColumnIndex(BaseColumns._ID)));
/**
The begin of a functional module: image resizing
This functional contains the bug
**/
Bundle extras = appWidgetManager.getAppWidgetOptions(widgetId);
int widgetWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,extras.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH), displayMetrics);
int widgetHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,extras.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT), displayMetrics);
Bitmap image;
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri), null, options);
int width = options.outWidth;
int height = options.outHeight;
options.inJustDecodeBounds = false;
/**
The end of the functional module: image resizing
**/
options.inSampleSize = Math.min(ImageUtil.calculateSampleSize(width, widgetWidth),ImageUtil.calculateSampleSize(height, widgetHeight));
image = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri), null, options);//The functional module of image decoding
remoteViews.setImageViewBitmap(R.id.widget_background, image);//The functional module of image displaying
