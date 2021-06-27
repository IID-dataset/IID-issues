Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(final Bundle savedInstanceState) {
mImageLoader = app.getMediaLoaderWrapper();
public MediaLoaderWrapper getMediaLoaderWrapper() {
return mMediaLoaderWrapper = new MediaLoaderWrapper(getImageLoader(), getVideoLoader());
public ImageLoader getImageLoader() {
cb.diskCache(getDiskCache());
public DiskCache getDiskCache() {
return mDiskCache = createDiskCache(DIR_NAME_IMAGE_CACHE);
private DiskCache createDiskCache(final String dirName) {
final File cacheDir = getBestCacheDir(this, dirName);
final File fallbackCacheDir = getInternalCacheDir(this, dirName);
final URLFileNameGenerator fileNameGenerator = new URLFileNameGenerator();
return new LruDiskCache(cacheDir, fallbackCacheDir, fileNameGenerator,384 * 1024 * 1024, 0);//buggy code

Error description:line 18, inappropriate code implementation
