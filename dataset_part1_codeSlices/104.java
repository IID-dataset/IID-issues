Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public int memCacheSize = DEFAULT_MEM_CACHE_SIZE;
public final int diskCacheSize = DEFAULT_DISK_CACHE_SIZE;//buggy code
public void onPause() {
ImageFetcher imageFetcher = ImageFetcher.getInstance(this);
public static ImageFetcher getInstance(Context context) {
sImageFetcher.addImageCache(imageCacheParams);
public void addImageCache(ImageCache.ImageCacheParams imageCacheParams) {
new CacheAsyncTask().execute(MESSAGE_INIT_DISK_CACHE);
protected class CacheAsyncTask extends AsyncTask<Object, Void, Void> {
protected Void doInBackground(Object... params) {
initDiskCacheInternal();
protected void initDiskCacheInternal() {
if (mImageCache != null) {
mImageCache.initDiskCache();
public void initDiskCache() {
if (mDiskLruCache == null || mDiskLruCache.isClosed()) {
File diskCacheDir = mCacheParams.diskCacheDir;
if (mCacheParams.diskCacheEnabled && diskCacheDir != null) {
if (!diskCacheDir.exists()) {
diskCacheDir.mkdirs();
long usableSpace = getUsableSpace(diskCacheDir);
long diskCacheSize = Math.round(Math.min(usableSpace * mCacheParams.diskCacheSizePercent,MAX_DISK_CACHE_SIZE));
if (usableSpace > diskCacheSize) {
mDiskLruCache = DiskLruCache.open(diskCacheDir, 1, 1, diskCacheSize);


