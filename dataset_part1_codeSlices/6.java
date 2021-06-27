Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onStart(Intent intent, int startId) {
uploadNextPost();
private void uploadNextPost(){
currentTask = new UploadPostTask();
currentTask.execute(currentUploadingPost);
protected Boolean doInBackground(Post... posts) {
String imgPath = m.group(1);
if (!imgPath.equals("")) {
MediaFile mf = WordPress.wpDB.getMediaFile(imgPath, post);
if (mf != null) {
String imgHTML = uploadMediaFile(mf, blog);
public String uploadMediaFile(MediaFile mf, Blog blog) {
curImagePath = mf.getFilePath();
Uri imageUri = Uri.parse(curImagePath);
File imageFile = null;
String mimeType = "", orientation = "", path = "";
if (imageUri.toString().contains("content:")) {
Uri imgPath;
imgPath = imageUri;
Cursor cur = context.getContentResolver().query(imgPath, projection, null, null, null);
if (cur.moveToFirst()) {
int dataColumn, mimeTypeColumn, orientationColumn;
dataColumn = cur.getColumnIndex(Images.Media.DATA);
mimeTypeColumn = cur.getColumnIndex(Images.Media.MIME_TYPE);
orientationColumn = cur.getColumnIndex(Images.Media.ORIENTATION);
 orientation = cur.getString(orientationColumn);
String thumbData = cur.getString(dataColumn);
mimeType = cur.getString(mimeTypeColumn);
imageFile = new File(thumbData);
path = thumbData;
mf.setFilePath(imageFile.getPath());
if (TextUtils.isEmpty(mimeType)) {
mimeType = getMediaFileMimeType(imageFile, true);
String fileName = getMediaFileName(imageFile, mimeType);
ImageHelper ih = new ImageHelper();
orientation = ih.getExifOrientation(path, orientation);
String resizedPictureURL = null;
boolean shouldUploadResizedVersion = false;
if (!mimeType.equals("image/gif") && !blog.getMaxImageWidth().equals("Original Size")) {
int pictureSettingWidth = mf.getWidth();
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(path, options);
int imageHeight = options.outHeight;
int imageWidth = options.outWidth;
int[] dimensions = {imageWidth, imageHeight};
if (dimensions[0] != 0 && dimensions[0] != pictureSettingWidth) {
shouldUploadResizedVersion = true;
if (shouldUploadResizedVersion) {
byte[] bytes;
byte[] finalBytes;
bytes = new byte[(int) imageFile.length()];
String width = String.valueOf(mf.getWidth());
String fileExtensionThumb = MimeTypeMap.getFileExtensionFromUrl(fileName).toLowerCase();
finalBytes = ih.createThumbnail(bytes, width, orientation, false, fileExtensionThumb);
public byte[] createThumbnail(byte[] bytes, String sMaxImageWidth, String orientation, boolean tiny, String fileExtension) {
int finalHeight = 0;
BitmapFactory.Options opts = new BitmapFactory.Options();
opts.inJustDecodeBounds = true;
/**
The end of the functional module: image resizing
**/
Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);//The functional module of image decoding
int width = opts.outWidth;
int finalWidth = 500;
if (tiny) {
finalWidth = 150;
byte[] finalBytes;
if (sMaxImageWidth.equals("Original Size")) {
} else {
finalWidth = Integer.parseInt(sMaxImageWidth);
if (finalWidth > width) {
} else {
int sample = 0;
float fWidth = width;
sample = Double.valueOf(FloatMath.ceil(fWidth / 1200)).intValue();
if (sample == 3) {
sample = 4;
opts.inSampleSize = sample;
opts.inJustDecodeBounds = false;
bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);//The functional module of image decoding
/**
The begin of a functional module: image resizing
**/
float percentage = (float) finalWidth / bm.getWidth();
float proportionateHeight = bm.getHeight() * percentage;
finalHeight = (int) Math.rint(proportionateHeight);
float scaleWidth = ((float) finalWidth) / bm.getWidth();
float scaleHeight = ((float) finalHeight) / bm.getHeight();
float scaleBy = Math.min(scaleWidth, scaleHeight);
Matrix matrix = new Matrix();
matrix.postScale(scaleBy, scaleBy);
/**
The end of the functional module: image resizing
**/
if ((orientation != null) && (orientation.equals("90") || orientation.equals("180") || orientation.equals("270"))) {
matrix.postRotate(Integer.valueOf(orientation));
Bitmap resized;
resized = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);//The functional module of image decoding
ByteArrayOutputStream baos = new ByteArrayOutputStream();
Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
if (fileExtension != null && fileExtension.equalsIgnoreCase("png"))
format = Bitmap.CompressFormat.PNG;
resized.compress(format, 85, baos);//The functional module of image disk caching
bm.recycle(); 
resized.recycle();
finalBytes = baos.toByteArray();
return finalBytes;
Map<String, Object> m = new HashMap<String, Object>();
m.put("bits", finalBytes);
String fullSizeUrl = null;
if (!shouldUploadResizedVersion || blog.isFullSizeImage()) {
Map<String, Object> m = new HashMap<String, Object>();
fullSizeUrl = uploadPicture(m, mf, blog);


Error description: line 44, inappropriate code implementation.

































