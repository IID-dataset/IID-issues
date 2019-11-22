Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(@Nullable Bundle savedInstanceState) {
mContentUri = savedInstanceState.getString(ARG_MEDIA_CONTENT_URI);
mMediaId = savedInstanceState.getInt(ARG_MEDIA_LOCAL_ID);
String mediaUri = null;
MediaModel media = mMediaStore.getMediaWithLocalId(mMediaId);
mediaUri = media.getUrl();
loadImage(mediaUri);
private void loadImage(@NonNull String mediaUri) {
int width = DisplayUtils.getDisplayPixelWidth(this);
int height = DisplayUtils.getDisplayPixelHeight(this);
int size = Math.max(width, height);
if (mediaUri.startsWith("http")) {
} else {
byte[] bytes = ImageUtils.createThumbnailFromUri(this, Uri.parse(mediaUri), size, null, 0);
public static byte[] createThumbnailFromUri(Context context,Uri imageUri,int maxWidth,String fileExtension,int orientation) {
ByteArrayOutputStream stream = new ByteArrayOutputStream();
/**
The begin of a functional module: image resizing
**/
boolean res = resizeImageAndWriteToStream(context, imageUri, fileExtension, maxWidth, orientation, 75, stream);
private static boolean resizeImageAndWriteToStream(Context context,Uri imageUri,String fileExtension,int maxWidth,int orientation,int quality,OutputStream outStream) throws OutOfMemoryError, IOException {
String realFilePath = getRealFilePath(context, imageUri);
BitmapFactory.Options optBounds = new BitmapFactory.Options();
optBounds.inJustDecodeBounds = true;
BitmapFactory.decodeFile(realFilePath, optBounds);
int scale = 1;
if (maxWidth > 0 && optBounds.outWidth > maxWidth) {
double d = Math.pow(2, (int) Math.round(Math.log(maxWidth / (double) optBounds.outWidth) / Math.log(0.5)));
scale = (int) d;
BitmapFactory.Options optActual = new BitmapFactory.Options();
optActual.inSampleSize = scale;
/**
The end of the functional module: image resizing
**/
final Bitmap bmpResized;
bmpResized = BitmapFactory.decodeFile(realFilePath, optActual);//The functional module of image resizing
/**
The begin of a functional module: image resizing
**/
float percentage = (float) maxWidth / bmpResized.getWidth();
float proportionateHeight = bmpResized.getHeight() * percentage;
int finalHeight = (int) Math.rint(proportionateHeight);
float scaleWidth = ((float) maxWidth) / bmpResized.getWidth();
float scaleHeight = ((float) finalHeight) / bmpResized.getHeight();
float scaleBy = Math.min(scaleWidth, scaleHeight);
Matrix matrix = new Matrix();
matrix.postScale(scaleBy, scaleBy);
Bitmap.CompressFormat fmt;
if (fileExtension != null &&
} else {
fmt = Bitmap.CompressFormat.JPEG;
final Bitmap bmpRotated;
bmpRotated = Bitmap.createBitmap(bmpResized, 0, 0, bmpResized.getWidth(), bmpResized.getHeight(), matrix, true);
/**
The end of the functional module: image resizing
**/
return bmpRotated.compress(fmt, quality, outStream);//The functional module of image disk caching
return stream.toByteArray();
Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);//The functional module of image resizing
/**
The begin of a functional module: image displaying
**/
if (bmp != null) {
setBitmap(bmp);
private void setBitmap(@NonNull Bitmap bmp) {
mImageView.setImageBitmap(bmp);
/**
The end of the functional module: image displaying
**/





















