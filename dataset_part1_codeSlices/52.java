Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode,final Intent intent) {
scaleDownImageIfNeeded(Collect.TMPFILE_PATH);
private void scaleDownImageIfNeeded(String path) {
QuestionWidget questionWidget = getWidgetWaitingForBinaryData();
if (questionWidget != null) {
Integer maxPixels = getMaxPixelsForImageIfDefined(questionWidget);
if (maxPixels != null) {
scaleDownImage(path, maxPixels);
private void scaleDownImage(String path, int maxPixels) {
Bitmap originalImage = BitmapFactory.decodeFile(path);//The functional module of image decoding
/**
The begin of a functional module: image resizing
**/
if (originalImage != null) {
double originalWidth = originalImage.getWidth();
double originalHeight = originalImage.getHeight();
int originalPixelCount = (int) (originalWidth * originalHeight);
if (originalPixelCount > maxPixels) {
double newWidth = Math.sqrt(maxPixels / (originalHeight / originalWidth));
double newHeight = Math.sqrt(maxPixels / (originalWidth / originalHeight));
Bitmap scaledImage = Bitmap.createScaledBitmap(originalImage, (int) newWidth, (int) newHeight, false);
/**
The end of the functional module: image resizing
**/
FileUtils.saveBitmapToFile(scaledImage, path);
public static void saveBitmapToFile(Bitmap bitmap, String path) {
FileOutputStream out = null;
out = new FileOutputStream(path);
bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);//The functional module of image disk caching

Error description:line 19--26, inappropriate code implementation.