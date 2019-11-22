Triggering condition: displaying a large image or a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate(Bundle savedInstanceState) {
if (savedMediaQueued != null) {
for (SavedQueuedMedia item : savedMediaQueued) {
addMediaToQueue(item.type, item.preview, item.uri, item.mediaSize);
private void addMediaToQueue(QueuedMedia.Type type, Bitmap preview, Uri uri, long mediaSize) {
if (mediaSize > STATUS_MEDIA_SIZE_LIMIT && type == QueuedMedia.Type.IMAGE) {
downsizeMedia(item);
private void downsizeMedia(final QueuedMedia item) {
item.readyStage = QueuedMedia.ReadyStage.DOWNSIZING;
new DownsizeImageTask(STATUS_MEDIA_SIZE_LIMIT, getContentResolver(),new DownsizeImageTask.Listener() {}).execute(item.uri);
protected Boolean doInBackground(Uri... uris) {
resultList = new ArrayList<>();
for (Uri uri : uris) {
InputStream inputStream;
inputStream = contentResolver.openInputStream(uri);
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(inputStream, null, options);
int beforeWidth = options.outWidth;
int beforeHeight = options.outHeight;
IOUtils.closeQuietly(inputStream);
int orientation = getOrientation(uri, contentResolver);
ByteArrayOutputStream stream = new ByteArrayOutputStream();
int iterations = 0;
int scaledImageSize = 1024;
do {
stream.reset();
inputStream = contentResolver.openInputStream(uri);
options.inSampleSize = calculateInSampleSize(beforeWidth, beforeHeight,scaledImageSize);
options.inJustDecodeBounds = false;
/**
The end of the functional module: image resizing
**/
Bitmap scaledBitmap;
scaledBitmap = BitmapFactory.decodeStream(inputStream, null, options);//The functional module of image decoding
Bitmap reorientedBitmap = reorientBitmap(scaledBitmap, orientation);
private static Bitmap reorientBitmap(Bitmap bitmap, int orientation) {
Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(), matrix, true);//The functional module of image decoding
bitmap.recycle();   //buggy code
return result;
Bitmap.CompressFormat format;
if (!reorientedBitmap.hasAlpha()) {
format = Bitmap.CompressFormat.JPEG;
reorientedBitmap.compress(format, 75, stream);//The functional module of image disk caching
reorientedBitmap.recycle();


