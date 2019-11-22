Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
WordPress.sImageLoader.get(url, new ImageLoader.ImageListener() {};
public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
Bitmap bitmap = response.getBitmap();//The functional module of image decoding
if (bitmap == null && !isImmediate) {
} else {//buggy code
final String cacheKey = url + maxWidthForEditor;
WordPress.getBitmapCache().putBitmap(cacheKey, bitmap);   
BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
callbacks.onImageLoaded(bitmapDrawable);////The functional module of image displaying