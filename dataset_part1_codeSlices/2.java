Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
File f = new File(mMediaCapturePath);
Uri capturedImageUri = Uri.fromFile(f);
if (!addMedia(capturedImageUri, null))
private boolean addMedia(Uri imageUri, SpannableStringBuilder ssb) {
if (ssb != null && !MediaUtils.isInMediaStore(imageUri))
imageUri = MediaUtils.downloadExternalMedia(getActivity(), imageUri);
Bitmap thumbnailBitmap;
if (imageUri.toString().contains("video") && !MediaUtils.isInMediaStore(imageUri)) {
} else {
ImageHelper ih = new ImageHelper();
Map<String, Object> mediaData = ih.getImageBytesForPath(imageUri.getEncodedPath(), getActivity());
public Map<String, Object> getImageBytesForPath(String filePath, Context ctx) {
Uri curStream = null;
String[] projection;
Map<String, Object> mediaData = new HashMap<String, Object>();
String title = "", orientation = "";
byte[] bytes;
if (filePath != null) {
if (!filePath.contains("content://"))
curStream = Uri.parse("content://media" + filePath);
if (curStream != null) {
if (filePath.contains("video")) {
} else {
projection = new String[] { Images.Thumbnails._ID, Images.Thumbnails.DATA, Images.Media.ORIENTATION };
Cursor cur;
cur = ctx.getContentResolver().query(curStream, projection, null, null, null);
File jpeg = null;
 if (cur != null) {
String thumbData = "";
if (cur.moveToFirst()) {
int dataColumn;
dataColumn = cur.getColumnIndex(Images.Media.DATA);
thumbData = cur.getString(dataColumn);
jpeg = new File(thumbData);
bytes = new byte[(int) jpeg.length()];
mediaData.put("bytes", bytes);
return mediaData;
thumbnailBitmap = ih.getThumbnailForWPImageSpan(getActivity(), (byte[]) mediaData.get("bytes"), (String) mediaData.get("orientation")); 
/**
The begin of a functional module: image resizing
This functional module is the buggy code
**/
public Bitmap getThumbnailForWPImageSpan(Context ctx, byte[] bytes, String orientation) {   
Display display = ((Activity)ctx).getWindowManager().getDefaultDisplay();
int width = display.getWidth();
int height = display.getHeight();
if (width > height)
width = height;
BitmapFactory.Options opts = new BitmapFactory.Options();
opts.inJustDecodeBounds = true;
BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);
float conversionFactor = 0.40f;
if (opts.outWidth > opts.outHeight)
conversionFactor = 0.70f;
byte[] finalBytes = createThumbnail(bytes, String.valueOf((int) (width * conversionFactor)),orientation, true, null);
public byte[] createThumbnail(byte[] bytes, String sMaxImageWidth, String orientation, boolean tiny, String fileExtension) {
int finalHeight = 0;
BitmapFactory.Options opts = new BitmapFactory.Options();
opts.inJustDecodeBounds = true;
Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);
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
/**
The end of the functional module: image resizing
**/
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
/**
The begin of a functional module: image disk caching
**/
ByteArrayOutputStream baos = new ByteArrayOutputStream();
Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
if (fileExtension != null && fileExtension.equalsIgnoreCase("png"))
format = Bitmap.CompressFormat.PNG;
resized.compress(format, 85, baos);
/**
The end of the functional module: image disk caching
**/
bm.recycle();
resized.recycle();
finalBytes = baos.toByteArray();
return finalBytes;
return BitmapFactory.decodeByteArray(finalBytes, 0, finalBytes.length);//image decoding
WPImageSpan is = new WPImageSpan(getActivity(), thumbnailBitmap, imageUri);//The functional module of image displaying







