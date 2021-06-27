Triggering condition: handling a lot of images
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void loadImage(String url, final Callbacks callbacks, int maxWidth) {
final int maxWidthForEditor = ImageUtils.getMaximumThumbnailWidthForEditor(context);
if (new File(url).exists()) {
int orientation = ImageUtils.getImageOrientation(this.context, url);
byte[] bytes = ImageUtils.createThumbnailFromUri(context, Uri.parse(url), maxWidthForEditor, null, orientation);------------------decoding
if (bytes != null) {
Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);//The functional module of image decoding
//buggy position      lack of image memory caching
BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
callbacks.onImageLoaded(bitmapDrawable);//The functional module of image displaying

Error description:line 12, lack of necessary functional modules
