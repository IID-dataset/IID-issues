Triggering condition: handling a lot of images
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void loadImage(String url, final Callbacks callbacks, int maxWidth) {
WordPress.sImageLoader.get(url, new ImageLoader.ImageListener() {
public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
Bitmap bitmap = response.getBitmap();
//buggy position      lack of image memory caching
if (bitmap == null && !isImmediate) {
} else if (bitmap != null) {
BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
callbacks.onImageLoaded(bitmapDrawable);//The functional module of image displaying

Error description:line 9, lack of necessary functional modules














