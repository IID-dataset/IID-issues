Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected Boolean doInBackground(ArtworkSource... params) {
ArtworkSource artworkSource = params != null && params.length == 1? params[0]: MuzeiDatabase.getInstance(mContext).artworkDao().getCurrentArtworkWithSourceBlocking();
Uri imageUri = artworkSource.artwork.getContentUri();
Bundle extras = new Bundle();
DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
int minWidgetSize = mContext.getResources().getDimensionPixelSize(R.dimen.widget_min_size);
for (int widgetId : appWidgetIds) {
/**
The begin of a functional module: image resizing
**/
Bundle extras = appWidgetManager.getAppWidgetOptions(widgetId);
int widgetWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, extras.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH), displayMetrics);
widgetWidth = Math.max(widgetWidth, minWidgetSize);//buggy code
int widgetHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, extras.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT), displayMetrics);
widgetHeight = Math.max(widgetHeight, minWidgetSize);//buggy code
RemoteViews remoteViews = createRemoteViews(imageUri, contentDescription, launchPendingIntent, nextArtworkPendingIntent, supportsNextArtwork, widgetWidth, widgetHeight);
private RemoteViews createRemoteViews(Uri imageUri, String contentDescription,PendingIntent launchPendingIntent,PendingIntent nextArtworkPendingIntent, boolean supportsNextArtwork,int widgetWidth, int widgetHeight) {
ContentResolver contentResolver = mContext.getContentResolver();
int smallWidgetHeight = mContext.getResources().getDimensionPixelSize(R.dimen.widget_small_height_breakpoint);
Bitmap image;
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri), null, options);
int width = options.outWidth;
int height = options.outHeight;
options.inJustDecodeBounds = false;
options.inSampleSize = Math.min(ImageUtil.calculateSampleSize(width, widgetWidth),ImageUtil.calculateSampleSize(height, widgetHeight));
/**
The end of the functional module: image resizing
**/
/**
The begin of a functional module: image decoding
**/
image = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri), null, options);
Bitmap scaledImage = scaleBitmap(image, widgetWidth, widgetHeight);
private Bitmap scaleBitmap(Bitmap image, int widgetWidth, int widgetHeight) {
int largestDimension = Math.max(widgetWidth, widgetHeight);
int width = image.getWidth();
int height = image.getHeight();
if (width > height) {
float ratio = (float) width / largestDimension;
width = largestDimension;
height = (int) (height / ratio);
return Bitmap.createScaledBitmap(image, width, height, true);
/**
The end of the functional module: image decoding
**/
@LayoutRes int widgetLayout = widgetHeight < smallWidgetHeight? R.layout.widget_small: R.layout.widget;
RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), widgetLayout);
/**
The begin of a functional module: image displaying
**/
remoteViews.setImageViewBitmap(R.id.widget_background, scaledImage);
appWidgetManager.updateAppWidget(widgetId, remoteViews);
/**
The end of a functional module: image displaying
**/







