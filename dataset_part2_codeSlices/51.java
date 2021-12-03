Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void setImage(@NonNull File imageFile) {
setupImage(imageFile);
private void setupImage(File imageFile) {
String errorMsg = null;
if (imageFile.exists()) {
/**
The begin of a functional module: image decoding
**/
Bitmap b = FileUtils.getBitmapScaledToDisplay(imageFile, ScreenUtils.getScreenHeight(), ScreenUtils.getScreenWidth());
public static Bitmap getBitmapScaledToDisplay(File file, int screenHeight, int screenWidth, boolean upscaleEnabled) {
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
getBitmap(file.getAbsolutePath(), options);
Bitmap bitmap;
double scale;
if (upscaleEnabled) {
options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
bitmap = getBitmap(file.getAbsolutePath(), options);
double heightScale = ((double) (options.outHeight)) / screenHeight;
double widthScale = ((double) options.outWidth) / screenWidth;
scale = Math.max(widthScale, heightScale);
double newHeight = Math.ceil(options.outHeight / scale);
double newWidth = Math.ceil(options.outWidth / scale);
itmap = Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, false);
return bitmap
/**
The end of the functional module: image decoding
**/
/**
The begin of a functional module: image displaying
**/
if (b != null) {
imageView.setImageBitmap(b);
/**
The end of the functional module: image displaying
**/

     
Error description:line 16-34, inappropriate code implementation







