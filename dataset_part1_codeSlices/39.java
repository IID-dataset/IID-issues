Triggering condition: displaying a lot of images
Consequence: app slowdown or app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onStart() {
if (getFile() != null) {
mLoadBitmapTask = new LoadBitmapTask(mImageView, mMessageView, mProgressWheel);
mLoadBitmapTask.execute(getFile().getStoragePath());
protected Bitmap doInBackground(String... params) {
Bitmap result = null;
String storagePath = params[0];
InputStream is = null;
if (isCancelled()) return result;
File picture = new File(storagePath);
if (picture != null) {
is = new FlushedInputStream(new BufferedInputStream(new FileInputStream(picture)));
result = BitmapFactory.decodeStream(new FlushedInputStream(new BufferedInputStream(new FileInputStream(picture))));//The functional module of image decoding    buggy code
if (result == null) {
} else {
result = BitmapUtils.rotateImage(result, storagePath);
return result;
protected void onPostExecute(Bitmap result) {
if (result != null) {
showLoadedImage(result);
private void showLoadedImage(Bitmap result) {
final ImageViewCustom imageView = mImageViewRef.get();
if (imageView != null) {
imageView.setImageBitmap(result);//The functional module of image displaying










































