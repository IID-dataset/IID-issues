Triggering condition: handling a lot of images
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onBindViewHolder(GridViewHolder holder, int position) {
loadLocalImage(media.getFilePath(), holder.imageView);
private void loadLocalImage(final String filePath, ImageView imageView) {
Bitmap bitmap = WordPress.getBitmapCache().get(filePath);
new BitmapWorkerTask(imageView, mThumbWidth, mThumbHeight, new BitmapWorkerCallback() {}).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, filePath);
public static class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
private int targetWidth;
private int targetHeight;
private String path;
public BitmapWorkerTask(ImageView imageView, int width, int height, BitmapWorkerCallback callback) {
targetWidth = width;
targetHeight = height;
/**
The begin of a functional module: image resizing
**/
protected Bitmap doInBackground(String... params) {
path = params[0];
BitmapFactory.Options bfo = new BitmapFactory.Options();
bfo.inJustDecodeBounds = true;
BitmapFactory.decodeFile(path, bfo);
bfo.inSampleSize = calculateInSampleSize(bfo, targetWidth, targetHeight);
public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
final int height = options.outHeight;
final int width = options.outWidth;
int inSampleSize = 1;
if (height > reqHeight || width > reqWidth) {
final int heightRatio = Math.round((float) height / (float) reqHeight);
final int widthRatio = Math.round((float) width / (float) reqWidth);
inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
return inSampleSize;
/**
The end of the functional module: image resizing
**/
bfo.inJustDecodeBounds = false;
int bitmapWidth = 0;
int bitmapHeight = 0;
File f = new File(path);
ExifInterface exif = new ExifInterface(f.getPath());
Bitmap bmp = BitmapFactory.decodeStream(new FileInputStream(f), null, bfo);//The functional module for image decoding
bitmapWidth = bmp.getWidth();
bitmapHeight = bmp.getHeight();
return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), mat, true);
public void run() {
WordPress.getBitmapCache().put(path, bitmap);//The functional module for image disk caching
public static BitmapLruCache getBitmapCache() {
if (mBitmapCache == null) {
int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
int cacheSize = maxMemory / 16;//buggy code
mBitmapCache = new BitmapLruCache(cacheSize);
return mBitmapCache;
if (imageView != null&& imageView.getTag() instanceof String&& ((String)imageView.getTag()).equalsIgnoreCase(path)) {
imageView.setImageBitmap(bitmap);//The functional module for image displaying

//The following statement sequence will be repeated many times
public void onBindViewHolder(GridViewHolder holder, int position) {
loadLocalImage(media.getFilePath(), holder.imageView);
private void loadLocalImage(final String filePath, ImageView imageView) {
Bitmap bitmap = WordPress.getBitmapCache().get(filePath);
new BitmapWorkerTask(imageView, mThumbWidth, mThumbHeight, new BitmapWorkerCallback() {}).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, filePath);
public static class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
private int targetWidth;
private int targetHeight;
private String path;
public BitmapWorkerTask(ImageView imageView, int width, int height, BitmapWorkerCallback callback) {
targetWidth = width;
targetHeight = height;
/**
The begin of a functional module: image resizing
**/
protected Bitmap doInBackground(String... params) {
path = params[0];
BitmapFactory.Options bfo = new BitmapFactory.Options();
bfo.inJustDecodeBounds = true;
BitmapFactory.decodeFile(path, bfo);
bfo.inSampleSize = calculateInSampleSize(bfo, targetWidth, targetHeight);
public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
final int height = options.outHeight;
final int width = options.outWidth;
int inSampleSize = 1;
if (height > reqHeight || width > reqWidth) {
final int heightRatio = Math.round((float) height / (float) reqHeight);
final int widthRatio = Math.round((float) width / (float) reqWidth);
inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
return inSampleSize;
/**
The end of the functional module: image resizing
**/
bfo.inJustDecodeBounds = false;
int bitmapWidth = 0;
int bitmapHeight = 0;
File f = new File(path);
ExifInterface exif = new ExifInterface(f.getPath());
Bitmap bmp = BitmapFactory.decodeStream(new FileInputStream(f), null, bfo);//The functional module for image decoding 
bitmapWidth = bmp.getWidth();
bitmapHeight = bmp.getHeight();
return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), mat, true);//The functional module for image decoding 
public void run() {
WordPress.getBitmapCache().put(path, bitmap);//The functional module for image disk caching
public static BitmapLruCache getBitmapCache() {
return mBitmapCache;
if (imageView != null&& imageView.getTag() instanceof String&& ((String)imageView.getTag()).equalsIgnoreCase(path)) {
imageView.setImageBitmap(bitmap);//The functional module for image displaying









