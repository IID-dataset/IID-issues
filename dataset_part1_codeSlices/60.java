Triggering condition: displaying a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onHandleIntent(Intent intent) {
mCompressed = MediaStorage.resizeImage(this, file, msgId, compress);
public static File resizeImage(Context context, Uri uri, long msgId, int maxSize)throws FileNotFoundException {
return resizeImage(context, uri, msgId, maxSize, maxSize, COMPRESSION_QUALITY);
public static File resizeImage(Context context, Uri uri, long msgId, int maxWidth, int maxHeight, int quality)throws FileNotFoundException {
bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);//The functional module of image decoding          buggy code
/**
The begin of a functional module: image resizing
**/
float photoW = bitmap.getWidth();
float photoH = bitmap.getHeight();
float scaleFactor = Math.max(photoW / maxWidth, photoH / maxHeight);
int w = (int)(photoW / scaleFactor);
int h = (int)(photoH / scaleFactor);
/**
The end of the functional module: image resizing
**/
Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);//The functional module of image decoding
scaledBitmap = bitmapOrientation(context, uri, scaledBitmap);
String filename = String.format(COMPRESS_FILENAME_FORMAT, msgId);
final File compressedFile = new File(context.getCacheDir(), filename);
FileOutputStream stream = null;
stream = new FileOutputStream(compressedFile);
scaledBitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream);//The functional module of image disk caching
return compressedFile;

Error description:line 11, inappropriate code implementation




















































