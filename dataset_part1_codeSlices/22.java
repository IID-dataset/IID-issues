Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onTrimMemory(final int level) {
if (level < ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
int maxMemory = (int) (Runtime.getRuntime().freeMemory() / 1024);
int cacheSize = maxMemory / 16;
mBitmapCache.trimToSize(cacheSize);
//buggy code    lack the functional module of image cache releasing