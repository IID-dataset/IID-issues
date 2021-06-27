Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
Uri uri = intent.getData();
long mediaSize = MediaUtils.getMediaSize(getContentResolver(), uri);
pickMedia(uri, mediaSize)
private void pickMedia(Uri uri, long mediaSize) {
String mimeType = contentResolver.getType(uri);
if (mimeType != null) {
String topLevelType = mimeType.substring(0, mimeType.indexOf('/'));
switch (topLevelType) {
case "image": {
Bitmap bitmap = MediaUtils.getImageThumbnail(contentResolver, uri, thumbnailViewSize);
if (bitmap != null) {
addMediaToQueue(QueuedMedia.Type.IMAGE, bitmap, uri, mediaSize);
private void addMediaToQueue(@Nullable String id, QueuedMedia.Type type, Bitmap preview, Uri uri,long mediaSize, QueuedMedia.ReadyStage readyStage, @Nullable String description) {
final QueuedMedia item = new QueuedMedia(type, uri, new ProgressImageView(this),mediaSize, description);
ImageView view = item.preview;
view.setOnClickListener(v -> onMediaClick(item, v));
private void onMediaClick(QueuedMedia item, View view) {
PopupMenu popup = new PopupMenu(this, view);
popup.setOnMenuItemClickListener(menuItem -> {
switch (menuItem.getItemId()) {
case addCaptionId:
makeCaptionDialog(item);
private void makeCaptionDialog(QueuedMedia item) {
ImageView imageView = new ImageView(this);
/**
The begin of a functional module: image decoding+displaying
**/
Picasso.with(this).load(item.uri).into(imageView);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 34, misconfiguration of third-party libraries