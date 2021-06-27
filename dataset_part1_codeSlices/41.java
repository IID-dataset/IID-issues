Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View getView(int position, View convertView, ViewGroup parent) {
boolean allowedToCreateNewThumbnail = (ThumbnailsCacheManager.cancelPotentialThumbnailWork(file, fileIcon));
if (MimeTypeUtil.isImage(file)){
Bitmap thumbnail = ThumbnailsCacheManager.getBitmapFromDiskCache( String.valueOf(file.hashCode()));
if (thumbnail != null){
} else {
if (allowedToCreateNewThumbnail) {
final ThumbnailsCacheManager.ThumbnailGenerationTask task =new ThumbnailsCacheManager.ThumbnailGenerationTask(fileIcon);fileIcon.setImageDrawable(asyncDrawable);task.execute(file);
protected Bitmap doInBackground(Object... params) {
Bitmap thumbnail = null;
mFile = params[0];
mIsThumbnail = (Boolean) params[1];
if (mFile instanceof OCFile) {
thumbnail = doOCFileInBackground(mIsThumbnail);
private Bitmap doOCFileInBackground(Boolean isThumbnail) {
Bitmap thumbnail = null;
OCFile file = (OCFile)mFile;
final String imageKey = String.valueOf(file.getRemoteId());
thumbnail = getBitmapFromDiskCache(imageKey);
public static Bitmap getBitmapFromDiskCache(String key) {
if (mThumbnailCache != null) {
}else{
return null
if (thumbnail == null || file.needsUpdateThumbnail()) {
int px = getThumbnailDimension();
if (file.isDown()) {
/**
The begin of a functional module: image resizing
**/
Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromFile(file.getStoragePath(), px, px);//buggy code
public static Bitmap decodeSampledBitmapFromFile(String srcPath, int reqWidth, int reqHeight) {
final Options options = new Options();
options.inScaled = true;
options.inPurgeable = true;
if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD_MR1) {
options.inPreferQualityOverSpeed = false;
if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
options.inMutable = false;
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(srcPath, options);   
options.inSampleSize = calculateSampleFactor(options, reqWidth, reqHeight);
options.inJustDecodeBounds = false;
/**
The end of the functional module: image resizing
**/
return BitmapFactory.decodeFile(srcPath, options); //The functional module of image decoding
if (bitmap != null) {
thumbnail = addThumbnailToCache(imageKey, bitmap, file.getStoragePath(), px);//The functional module of image disk caching
private Bitmap addThumbnailToCache(String imageKey, Bitmap bitmap, String path, int pxW, int pxH){
Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, pxW, pxH);
thumbnail = BitmapUtils.rotateImage(thumbnail,path);
addBitmapToCache(imageKey, thumbnail);//The functional module of image memory caching
return thumbnail;
return thumbnail;
return thumbnail;
protected void onPostExecute(Bitmap bitmap){
if (mImageViewReference != null && bitmap != null) {
final ImageView imageView = mImageViewReference.get();
imageView.setImageBitmap(bitmap);//The functional module of image displaying

Error description:line 35, inappropriate code implementation



 	 

		 
		 



  
	
	
	