Triggering condition: displaying a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public int onStartCommand(Intent intent, int flags, int startId) {
handleIntent(intent);
private void handleIntent(Intent intent) {
sendMessage(intent.getExtras());
private void sendMessage(Bundle data) {
if (_previewUri != null && previewFilename != null) {
File previewPath = new File(previewFilename);
if (!previewPath.isFile()) {
Uri previewUri = Uri.parse(_previewUri);
MediaStorage.cacheThumbnail(this, previewUri, previewPath);
public static void cacheThumbnail(Context context, Uri media, File destination) throws IOException {
FileOutputStream fout = new FileOutputStream(destination);
cacheThumbnail(context, media, fout);
private static void cacheThumbnail(Context context, Uri media, FileOutputStream fout) throws IOException {
ContentResolver cr = context.getContentResolver();
InputStream in = cr.openInputStream(media);
BitmapFactory.Options options = preloadBitmap(in, THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
/**
The begin of a functional module: image resizing
**/
private static BitmapFactory.Options preloadBitmap(InputStream in) {
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeStream(in, null, options);
return processOptions(options);      //buggy code
private static BitmapFactory.Options processOptions(BitmapFactory.Options options) {
int w = options.outWidth;
int h = options.outHeight;
if (w < 0 || h < 0) return null;
if (w > THUMBNAIL_WIDTH)
options.inSampleSize = (w / THUMBNAIL_WIDTH);
else if (h > THUMBNAIL_HEIGHT)
options.inSampleSize = (h / THUMBNAIL_HEIGHT);
options.inJustDecodeBounds = false;
options.inPreferredConfig = Bitmap.Config.RGB_565;
return options;
/**
The end of the functional module: image resizing
**/
in = cr.openInputStream(media);
Bitmap bitmap = BitmapFactory.decodeStream(in, null, options);//The functional module of image decoding
Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
bitmap.recycle();//The functional module of image releasing
thumbnail = bitmapOrientation(context, media, thumbnail);
thumbnail.compress(Bitmap.CompressFormat.PNG, 90, fout);//The functional module of image disk caching
thumbnail.recycle();//The functional module of image releasing

Error description:line 30-41, inappropriate code implementation




  






































