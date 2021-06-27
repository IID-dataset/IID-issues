Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void bindView(View view, Context context, Cursor cursor) {
case Imps.MessageType.POSTPONED:
int errCode = cursor.getInt(mErrCodeColumn);
if (errCode != 0) {
} else {
messageView.bindOutgoingMessage(id, messageType, null, mimeType, body, date, mMarkup, isScrolling(),deliveryState, encState);
public void bindOutgoingMessage(int id, int messageType, String address, final String mimeType, final String body, Date date, Markup smileyRes, boolean scrolling,DeliveryState delivery, EncryptionState encryption) {
if( mimeType != null ) {
Uri mediaUri = Uri.parse( body ) ;
showMediaThumbnail(mimeType, mediaUri, id, mHolder);
private void showMediaThumbnail (String mimeType, Uri mediaUri, int id, ViewHolder holder){
if( mimeType.startsWith("image/") ) {
setImageThumbnail( getContext().getContentResolver(), id, holder, mediaUri );
private void setImageThumbnail(final ContentResolver contentResolver, final int id, final ViewHolder aHolder, final Uri mediaUri) {
aHolder.mMediaUri = mediaUri;
setThumbnail(contentResolver, aHolder, mediaUri);
private void setThumbnail(final ContentResolver contentResolver, final ViewHolder aHolder, final Uri uri) {
new AsyncTask<String, Void, Bitmap>() {}.execute();
protected Bitmap doInBackground(String... params) {
Bitmap result = mBitmapCache.get(uri.toString());
if (result == null)
public final static int THUMBNAIL_SIZE = 400;
public static Bitmap getThumbnail(ContentResolver cr, Uri uri) {
return getThumbnailFile(cr, uri);
public static Bitmap getThumbnailFile(ContentResolver cr, Uri uri) {
java.io.File image = new java.io.File(uri.getPath());
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
options.inInputShareable = true;
options.inPurgeable = true;
BitmapFactory.decodeFile(image.getPath(), options);
int originalSize = (options.outHeight > options.outWidth) ? options.outHeight: options.outWidth;
BitmapFactory.Options opts = new BitmapFactory.Options();
opts.inSampleSize = originalSize / THUMBNAIL_SIZE;
Bitmap scaledBitmap = BitmapFactory.decodeFile(image.getPath(), opts);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
return scaledBitmap;
return getThumbnail( contentResolver, uri );
protected void onPostExecute(Bitmap result) {
if (uri != null && result != null)
mBitmapCache.put(uri.toString(), result);
aHolder.mMediaThumbnail.setImageBitmap(result);//The functional module of image displaying

Error description:line 35-43, inappropriate code implementation



