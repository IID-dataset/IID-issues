Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate() {
NewWallpaperNotificationReceiver.maybeShowNewArtworkNotification(MuzeiWallpaperService.this);
public static void maybeShowNewArtworkNotification(Context context) {
Bitmap largeIcon;
Bitmap background;
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(contentResolver.openInputStream(MuzeiContract.Artwork.CONTENT_URI), null, options);
int width = options.outWidth;
int height = options.outHeight;
int shortestLength = Math.min(width, height);
options = new BitmapFactory.Options();//buggy code
int largeIconHeight = context.getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height);
options.inSampleSize = ImageUtil.calculateSampleSize(shortestLength, largeIconHeight);
public static int calculateSampleSize(int rawSize, int targetSize) {
int sampleSize = 1;
while (rawSize / (sampleSize << 1) > targetSize) {
sampleSize <<= 1;
return sampleSize;
/**
The end of the functional module: image resizing
**/
largeIcon = BitmapFactory.decodeStream(contentResolver.openInputStream(MuzeiContract.Artwork.CONTENT_URI), null, options);//The functional module of image decoding
/**
The begin of a functional module: image resizing
**/
options.inSampleSize = ImageUtil.calculateSampleSize(height, 400);
public static int calculateSampleSize(int rawSize, int targetSize) {
int sampleSize = 1;
while (rawSize / (sampleSize << 1) > targetSize) {
sampleSize <<= 1;
return sampleSize;
/**
The end of the functional module: image resizing
**/
background = BitmapFactory.decodeStream(contentResolver.openInputStream(MuzeiContract.Artwork.CONTENT_URI), null, options);//The functional module of image decoding
NotificationCompat.Builder nb = new NotificationCompat.Builder(context.setLargeIcon(largeIcon);//The functional module of image disk caching

Error description:line 14-27, inappropriate code implementation
































