Triggering condition: no triggering condition description
Consequence: Application not responding

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
File f = new File(mMediaCapturePath);
Uri capturedImageUri = Uri.fromFile(f);
if (!addMedia(capturedImageUri)) {
public boolean addMedia(Uri mediaUri) {
if (mediaUri != null && !MediaUtils.isInMediaStore(mediaUri) && !mediaUri.toString().startsWith("/")&& !mediaUri.toString().startsWith("file://") ) {
mediaUri = MediaUtils.downloadExternalMedia(this, mediaUri);
if (mShowNewEditor || mShowAztecEditor) {
return addMediaVisualEditor(mediaUri, isVideo);
private boolean addMediaVisualEditor(Uri uri, boolean isVideo) {
String path;
if (uri.toString().contains("content:")) {
path = MediaUtils.getPath(this, uri);
Uri optimizedMedia = WPMediaUtils.getOptimizedMedia(this, mSite, path, isVideo);
public static Uri getOptimizedMedia(Activity activity, SiteModel siteModel, String path, boolean isVideo) {
SiteSettingsInterface siteSettings = SiteSettingsInterface.getInterface(activity, siteModel, null);
if (siteSettings != null && siteSettings.init(false).getOptimizedImage()) {
String optimizedPath = ImageUtils.optimizeImage(activity, path, OPTIMIZE_IMAGE_MAX_WIDTH, OPTIMIZE_IMAGE_ENCODER_QUALITY);
public static String optimizeImage(Context context, String path, int maxImageWidth, int quality) {
File file = new File(path);
String mimeType = MediaUtils.getMediaFileMimeType(file);
Uri srcImageUri = Uri.parse(path);
String fileName = MediaUtils.getMediaFileName(file, mimeType);
String fileExtension = MimeTypeMap.getFileExtensionFromUrl(fileName).toLowerCase();
int selectedWidth = getImageSize(srcImageUri, context)[0];
if (selectedWidth > maxImageWidth) {
selectedWidth = maxImageWidth;
int orientation = getImageOrientation(context, path);
File resizedImageFile;
FileOutputStream out;
resizedImageFile = File.createTempFile("wp-image-", "." + fileExtension);
out = new FileOutputStream(resizedImageFile);
boolean res = resizeImageAndWriteToStream(context, srcImageUri, fileExtension, selectedWidth, orientation, quality, out);
return path;

/**
The begin of a functional module: image resizing
**/
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
bmpResized = BitmapFactory.decodeFile(realFilePath, optActual);//the functional module of image decoding
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
if (orientation != 0) {
matrix.setRotate(orientation);
Bitmap.CompressFormat fmt;
if (fileExtension != null &&
(fileExtension.equals("png") || fileExtension.equals(".png"))) {
fmt = Bitmap.CompressFormat.PNG;
final Bitmap bmpRotated;
/**
The end of the functional module: image resizing
**/
bmpRotated = Bitmap.createBitmap(bmpResized, 0, 0, bmpResized.getWidth(), bmpResized.getHeight(), matrix, true);//The functional module of image decoding
return bmpRotated.compress(fmt, quality, outStream);//The functional module of image disk caching


































