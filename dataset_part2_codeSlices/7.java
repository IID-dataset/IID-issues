Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public static void execute(String imagePath, QuestionWidget questionWidget, Context context) {
rotateImageIfNeeded(imagePath);
private static void rotateImageIfNeeded(String imagePath) {
ExifInterface exif = null;
exif = new ExifInterface(imagePath);
if (exif != null) {
Bitmap image = FileUtils.getBitmap(imagePath, new BitmapFactory.Options());
/**
The begin of a functional module: image decoding
**/
public static Bitmap getBitmap(String path, BitmapFactory.Options originalOptions) {
BitmapFactory.Options newOptions = new BitmapFactory.Options();
newOptions.inSampleSize = originalOptions.inSampleSize;
if (newOptions.inSampleSize <= 0) {
newOptions.inSampleSize = 1;
Bitmap bitmap;
bitmap = BitmapFactory.decodeFile(path, originalOptions);//buggy code
return bitmap;
/**
The end of the functional module: image decoding
**/
int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
switch (orientation) {
case ExifInterface.ORIENTATION_ROTATE_90:
rotateBitmap(image, 90, imagePath);
private static void rotateBitmap(Bitmap image, int degrees, String imagePath) {
Matrix matrix = new Matrix();
matrix.postRotate(degrees);
image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
/**
The begin of a functional module: image disk caching
**/
FileUtils.saveBitmapToFile(image, imagePath);
public static void saveBitmapToFile(Bitmap bitmap, String path) {
final Bitmap.CompressFormat compressFormat = path.toLowerCase(Locale.getDefault()).endsWith(".png") ?Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
try (FileOutputStream out = new FileOutputStream(path)) {
bitmap.compress(compressFormat, 100, out);
/**
The end of the functional module: image disk caching
**/

