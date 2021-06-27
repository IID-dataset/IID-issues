Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onStart() {
if (getFile() == null || !getFile().isDown()) {
} else {
mLoadBitmapTask = new LoadBitmapTask(mImageView);//buggy code
mLoadBitmapTask.execute(getFile());//buggy code
protected LoadImage doInBackground(OCFile... params) {
Bitmap bitmapResult = null;
Drawable drawableResult = null;
OCFile ocFile = params[0];
String storagePath = ocFile.getStoragePath();
int maxDownScale = 3;
Point screenSize = DisplayUtils.getScreenSize(getActivity());
int minWidth = screenSize.x;
int minHeight = screenSize.y;
for (int i = 0; i < maxDownScale && bitmapResult == null && drawableResult == null; i++) {
if (ocFile.getMimetype().equalsIgnoreCase("image/svg+xml")) {
SVG svg = SVG.getFromInputStream(new FileInputStream(storagePath));
drawableResult = new PictureDrawable(svg.renderToPicture());
/**
The begin of a functional module: image resizing+decoding
**/
bitmapResult = BitmapUtils.decodeSampledBitmapFromFile(storagePath, minWidth,minHeight);
public static Bitmap decodeSampledBitmapFromFile(String srcPath, int reqWidth, int reqHeight) {
final Options options = new Options();
options.inScaled = true;
options.inPurgeable = true;
options.inPreferQualityOverSpeed = false;
options.inMutable = false;
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(srcPath, options);
options.inSampleSize = calculateSampleFactor(options, reqWidth, reqHeight);
private static int calculateSampleFactor(Options options, int reqWidth, int reqHeight) {
final int height = options.outHeight;
final int width = options.outWidth;
int inSampleSize = 1;
if (height > reqHeight || width > reqWidth) {
final int halfHeight = height / 2;
final int halfWidth = width / 2;
while ((halfHeight / inSampleSize) > reqHeight&& (halfWidth / inSampleSize) > reqWidth) {
inSampleSize *= 2;
return inSampleSize;
options.inJustDecodeBounds = false;
return BitmapFactory.decodeFile(srcPath, options);//image decoding
/**
The end of the functional module: image resizing+decoding
**/
if (ocFile.getMimetype().equalsIgnoreCase("image/jpeg")) {
bitmapResult = BitmapUtils.rotateImage(bitmapResult, storagePath);
return new LoadImage(bitmapResult, drawableResult, ocFile);
protected void onPostExecute(LoadImage result) {
if (result.bitmap != null || result.drawable != null) {
/**
The begin of a functional module: image displaying
**/
showLoadedImage(result);
private void showLoadedImage(LoadImage result) {
final ImageViewCustom imageView = mImageViewRef.get();
Bitmap bitmap = result.bitmap;
if (imageView != null) {
if (result.ocFile.getMimetype().equalsIgnoreCase("image/png") ||result.ocFile.getMimetype().equals("image/svg+xml")) {
if (getResources() != null) {
} else {
imageView.setImageBitmap(bitmap);
/**
The begin of the functional module: image displaying
**/
if (result.bitmap != null && mBitmap != result.bitmap) {
result.bitmap.recycle();//releasing the decoded image 


Error description:line 9, inappropriate code implementation

