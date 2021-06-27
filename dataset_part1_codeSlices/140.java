Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void bindView(View view, Context context, Cursor cursor) {
MessageView messageView = (MessageView) view;
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
public static Bitmap getThumbnail(ContentResolver cr, Uri uri) {
if (ChatFileStore.isVfsUri(uri)) {
return ChatFileStore.getThumbnailVfs(cr, uri);
public static Bitmap getThumbnailVfs(ContentResolver cr, Uri uri) {
File image = new File(uri.getPath());
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
options.inInputShareable = true;
options.inPurgeable = true;
FileInputStream fis = new FileInputStream(new File(image.getPath()));
BitmapFactory.decodeStream(fis, null, options);
int originalSize = (options.outHeight > options.outWidth) ? options.outHeight: options.outWidth;
BitmapFactory.Options opts = new BitmapFactory.Options();
opts.inSampleSize = originalSize / MessageView.THUMBNAIL_SIZE;//buggy code
/**
The end of the functional module: image resizing
**/
FileInputStream fis = new FileInputStream(new File(image.getPath()));
Bitmap scaledBitmap = BitmapFactory.decodeStream(fis, null, opts);//The functional module of image decoding
return scaledBitmap;
return getThumbnail( contentResolver, uri );
protected void onPostExecute(Bitmap result) {
if (uri != null && result != null)
mBitmapCache.put(uri.toString(), result);
aHolder.mMediaThumbnail.setImageBitmap(result);//The functional module of image displaying

Error description:line 44, inappropriate code implementation

