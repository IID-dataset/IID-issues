Triggering condition: handling a large image
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

/**
The begin of a functional module: setting image memory cache
**/
public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s)
ImageCache.ImageCacheParams cacheParams = new ImageCache.ImageCacheParams(FamiliarActivity.this, IMAGE_CACHE_DIR)
cacheParams.setMemCacheSizePercent(0.25f)
cacheParams.diskCacheSize = 1024 * 1024 * PreferenceAdapter.getImageCacheSize(FamiliarActivity.this)
public static synchronized int getImageCacheSize(@Nullable Context context)
if (null == context)
return 12; //buggy code
addImageCache(getSupportFragmentManager(), cacheParams)
private void addImageCache(FragmentManager fragmentManager,
ImageCache.ImageCacheParams cacheParams) {
mImageCache = ImageCache.getInstance(fragmentManager, cacheParams)
/**
The end of the functional module: setting image memory cache
**/

public void loadImage(Object data, ImageView imageView)
BitmapDrawable value = null
if (mImageCache != null)
value = mImageCache.getBitmapFromMemCache(String.valueOf(data))
public BitmapDrawable getBitmapFromMemCache(String data) 
BitmapDrawable memValue = null
return memValue
if (value != null) 
} else if (cancelPotentialWork(data, imageView))
final BitmapWorkerTask task = new BitmapWorkerTask(data, imageView)
task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
protected BitmapDrawable doInBackground(Void... params)
final String dataString = String.valueOf(mData)
Bitmap bitmap = null
BitmapDrawable drawable = null
if (mImageCache != null && !isCancelled() && getAttachedImageView() != null&& !mExitTasksEarly)

/**
The begin of a functional module: image decoding
**/
bitmap = mImageCache.getBitmapFromDiskCache(dataString)
public Bitmap getBitmapFromDiskCache(String data) 
final String key = hashKeyForDisk(data);
Bitmap bitmap = null;
InputStream inputStream = null;
final DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
if (snapshot != null) {
inputStream = snapshot.getInputStream(DISK_CACHE_INDEX);
if (inputStream != null) {
FileDescriptor fd = ((FileInputStream) inputStream).getFD();
bitmap = ImageResizer.decodeSampledBitmapFromDescriptor(fd, Integer.MAX_VALUE, Integer.MAX_VALUE, this)
public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight, ImageCache cache) 
final BitmapFactory.Options options = new BitmapFactory.Options()
options.inJustDecodeBounds = true
BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options)
options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
options.inJustDecodeBounds = false
return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options)
return bitmap
/**
The end of a functional module: image decoding
**/

if (bitmap != null)
if (Utils.hasHoneycomb()) 
drawable = new BitmapDrawable(mResources, bitmap)
if (mImageCache != null)
mImageCache.addBitmapToCache(dataString, drawable)
return drawable

/**
The begin of a functional module: image displaying
**/
protected void onPostExecute(BitmapDrawable value) 
final ImageView imageView = getAttachedImageView()
if (value != null && imageView != null) 
setImageDrawable(imageView, value)
private void setImageDrawable(ImageView imageView, Drawable drawable)
imageView.setImageDrawable(drawable)
/**
The end of a functional module: image displaying
**/


