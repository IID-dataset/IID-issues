Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
if (resultCode == RESULT_OK && requestCode == MEDIA_PICK_RESULT && intent != null) {
Uri uri = intent.getData();
long mediaSize = MediaUtils.getMediaSize(getContentResolver(), uri);
pickMedia(uri, mediaSize);
private void pickMedia(Uri uri, long mediaSize) {
ContentResolver contentResolver = getContentResolver();
String mimeType = contentResolver.getType(uri);
if (mimeType != null) {
String topLevelType = mimeType.substring(0, mimeType.indexOf('/'));
switch (topLevelType) {
case "image": {
Bitmap bitmap = MediaUtils.getImageThumbnail(contentResolver, uri, THUMBNAIL_SIZE);
if (bitmap != null) {
addMediaToQueue(QueuedMedia.Type.IMAGE, bitmap, uri, mediaSize);
private void addMediaToQueue(@Nullable String id, QueuedMedia.Type type, Bitmap preview, Uri uri, long mediaSize, QueuedMedia.ReadyStage readyStage, @Nullable String description) {
final QueuedMedia item = new QueuedMedia(type, uri, new ProgressImageView(this),mediaSize, description);
if (mediaSize > STATUS_MEDIA_SIZE_LIMIT && type == QueuedMedia.Type.IMAGE) {//buggy code
downsizeMedia(item);
private void downsizeMedia(final QueuedMedia item) {item.readyStage = QueuedMedia.ReadyStage.DOWNSIZING;
new DownsizeImageTask(STATUS_MEDIA_SIZE_LIMIT, getContentResolver(), new DownsizeImageTask.Listener() {}).execute(item.uri);

protected Boolean doInBackground(Uri... uris) {
/**
The begin of a functional module for image resizing
**/
for (Uri uri : uris) {
InputStream inputStream;
inputStream = contentResolver.openInputStream(uri);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(inputStream, null, options);
int beforeWidth = options.outWidth;
int beforeHeight = options.outHeight;
IOUtils.closeQuietly(inputStream);
int orientation = getOrientation(uri, contentResolver);
ByteArrayOutputStream stream = new ByteArrayOutputStream();
int scaledImageSize = 1024;
inputStream = contentResolver.openInputStream(uri);
options.inSampleSize = calculateInSampleSize(beforeWidth, beforeHeight,scaledImageSize);
private static int calculateInSampleSize(int width, int height, int requiredScale) {
int inSampleSize = 1;
if (height > requiredScale || width > requiredScale) {
final int halfHeight = height / 2;
final int halfWidth = width / 2;
while (halfHeight / inSampleSize >= requiredScale&& halfWidth / inSampleSize >= requiredScale) {
inSampleSize *= 2;
return inSampleSize;
/**
The end of the functional module for image resizing
**/
/**
The begin of a functional module for image decoding
**/
options.inJustDecodeBounds = false;
Bitmap scaledBitmap;
scaledBitmap = BitmapFactory.decodeStream(inputStream, null, options);
/**
The end of the functional module for image decoding
**/
Bitmap reorientedBitmap = reorientBitmap(scaledBitmap, orientation);//image transformation
/**
The begin of a functional module for image disk caching
**/
Bitmap.CompressFormat format;
if (!reorientedBitmap.hasAlpha()) {
format = Bitmap.CompressFormat.JPEG;
reorientedBitmap.compress(format, 85, stream);
/**
The end of a functional module for image disk caching
**/
reorientedBitmap.recycle();//releasing the image object





