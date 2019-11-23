Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onScrollChanged(int l, int t, int oldl, int oldt) {
requestLoadOfPendingPictures();
	void requestLoadOfPendingPictures() {
Rect r = new Rect();
ViewGroup vg = (ViewGroup)getChildAt(0);
int count = vg.getChildCount();
for (int i = 0; i < count; i++) {
ViewGroup picView = (ViewGroup)vg.getChildAt(i);
File image = new File((String)picView.getTag());
if (picView.getLocalVisibleRect(r) && !mTasks.containsKey(image)) {
ImageView iv = (ImageView)picView.findViewById(R.id.picture_thumbnail);
AsyncPictureLoaderTask task = new AsyncPictureLoaderTask(getContext(), iv);
task.execute(image);
protected Drawable doInBackground(File... params) {
int width = mView.getMeasuredWidth();
int height = mView.getMeasuredHeight();
public static Bitmap decodeBitmap(File file, int reqWidth, int reqHeight) {
/**
The begin of a functional module: image resizing
**/
final BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(file.getAbsolutePath(), options);
options.inSampleSize = calculateBitmapRatio(options, reqWidth, reqHeight);//buggy code
options.inJustDecodeBounds = false;
options.inPreferQualityOverSpeed = false;
options.inPurgeable = true;
options.inInputShareable = true;
options.inDither = true;
Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
return decodeExifBitmap(file, bitmap);
private static Bitmap decodeExifBitmap(File file, Bitmap bitmap) {
ExifInterface exif = new ExifInterface(file.getAbsolutePath());
int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
if (orientation == 0) {
return bitmap;
Bitmap bitmap = BitmapUtils.decodeBitmap(params[0], width, height);
if (bitmap != null) {
return new BitmapDrawable(mContext.getResources(), bitmap);
protected void onPostExecute(Drawable result) {
mView.setImageDrawable(result);//The functional module of image displaying







