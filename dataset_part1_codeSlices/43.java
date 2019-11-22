Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View getView(int position, View convertView, ViewGroup parent) {
File file = null;
if (mFiles != null && mFiles.length > position && mFiles[position] != null) {
file = mFiles[position];
if (file != null) {
if (!file.isDirectory()) {
if (MimeTypeUtil.isImage(file)){
Bitmap thumbnail = ThumbnailsCacheManager.getBitmapFromDiskCache(String.valueOf(file.hashCode()));
if (thumbnail != null){
} else {
if (allowedToCreateNewThumbnail) {
final ThumbnailsCacheManager.ThumbnailGenerationTask task =new ThumbnailsCacheManager.ThumbnailGenerationTask(fileIcon);
protected Bitmap doInBackground(Object... params) {
Bitmap thumbnail = null;
mFile = params[0];
mIsThumbnail = (Boolean) params[1];
if (mFile instanceof File) {
thumbnail = doFileInBackground(mIsThumbnail);
private Bitmap doFileInBackground() {
Bitmap thumbnail = null;
File file = (File)mFile;
final String imageKey = String.valueOf(file.hashCode());
thumbnail = getBitmapFromDiskCache(imageKey);
if (thumbnail == null) {
int px = getThumbnailDimension();
/**
The begin of a functional module: image resizing
**/
Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromFile(file.getAbsolutePath(), px, px);//buggy code
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
if (bitmap != null) {
thumbnail = addThumbnailToCache(imageKey, bitmap, file.getPath(), px);//The functional module of image memory caching
return thumbnail;
return thumbnail;
fileIcon.setImageBitmap(thumbnail);//The functional module of image displaying




