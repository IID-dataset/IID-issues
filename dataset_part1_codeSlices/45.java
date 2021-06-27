Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate() {
WearableController.updateArtwork(MuzeiWallpaperService.this);
public static synchronized void updateArtwork(Context context) {
ContentResolver contentResolver = context.getContentResolver();
Bitmap image = null;
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(contentResolver.openInputStream(
MuzeiContract.Artwork.CONTENT_URI), null, options);
options = new BitmapFactory.Options();  //buggy code  
if (options.outWidth > options.outHeight) {
options.inSampleSize = ImageUtil.calculateSampleSize(options.outHeight, 320);
public static int calculateSampleSize(int rawSize, int targetSize) {
int sampleSize = 1;
while (rawSize / (sampleSize << 1) > targetSize) {
sampleSize <<= 1;
return sampleSize;
/**
The end of the functional module: image resizing
**/
image = BitmapFactory.decodeStream(contentResolver.openInputStream(MuzeiContract.Artwork.CONTENT_URI), null, options);//The functional module of image decoding
if (image != null) {
final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
image.compress(Bitmap.CompressFormat.PNG, 100, byteStream);//The functional module of image disk caching

Error description:line 18, inappropriate code implementation







