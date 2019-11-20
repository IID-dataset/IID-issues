Triggering condition: not contain information about its triggering condition
Consequence: application not responding

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

private CachedImage getImage(Object objTag, long imageId, String path, boolean fromCacheOnly)
CachedImage image = get(path);
if (image != null) {
} else if (brokenBitmaps.contains(path)) {
} else if (!(new File(path)).exists()) {    //buggy code
} else {
misses.incrementAndGet();
if (!fromCacheOnly) {                   
image = loadImage(objTag, imageId, path)
private CachedImage loadImage(Object objTag, long imageId, String path)
Bitmap bitmap = loadBitmap(objTag, imageId, path)
private Bitmap loadBitmap(Object objTag, long imageId, String path)

Bitmap bitmap = null
if (MyPreferences.isShowDebuggingInfoInUi())
bitmap = BitmapFactory.decodeFile(path, calculateScaling(objTag, getImageSize(imageId, path)))
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options calculateScaling(Object objTag, Point imageSize)
BitmapFactory.Options options = new BitmapFactory.Options()
int x = maxBitmapWidth
int y = maxBitmapHeight
while (imageSize.y > y || imageSize.x > x)
options.inSampleSize = (options.inSampleSize < 2) ? 2 : options.inSampleSize * 2
x *= 2;
y *= 2;
return options
/**
The begin of a functional module: image decoding
**/
bitmap = BitmapFactory.decodeFile(path, calculateScaling(objTag, getImageSize(imageId, path)))
return bitmap
/**
The end of the functional module: image decoding
**/

/**
The begin of a functional module: image displaying
**/
Rect srcRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight())
Bitmap background = getSuitableRecycledBitmap(srcRect)
Canvas canvas = new Canvas(background)
canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
if (rounded)
} else {
canvas.drawBitmap(bitmap, 0 , 0, null)
/**
The end of the functional module: image displaying
**/
bitmap.recycle()
return new CachedImage(imageId, background, srcRect)
if (image != null) {
if (currentCacheSize > 0) {
put(path, image);       
