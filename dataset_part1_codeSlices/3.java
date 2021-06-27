Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
File f = new File(mMediaCapturePath);
Uri capturedImageUri = Uri.fromFile(f);
if (!addMedia(capturedImageUri)) {
private boolean addMedia(Uri mediaUri) {
mediaUri = MediaUtils.downloadExternalMedia(this, mediaUri);
if (mShowNewEditor || mShowAztecEditor) {
return addMediaVisualEditor(mediaUri, isVideo);
private boolean addMediaVisualEditor(Uri uri, boolean isVideo) {
String path;
path = getPathFromContentUri(uri);
MediaModel media = queueFileForUpload(uri, getContentResolver().getType(uri));
MediaFile mediaFile = FluxCUtils.mediaFileFromMediaModel(media);
mEditorFragment.appendMediaFile(mediaFile, path, WordPress.sImageLoader);
public void appendMediaFile(final MediaFile mediaFile, final String mediaUrl, ImageLoader imageLoader) {
final String safeMediaUrl = Utils.escapeQuotes(mediaUrl);
String localMediaId = String.valueOf(mediaFile.getId());
if (mediaFile.isVideo()) {
} else {
Bitmap bitmap = BitmapFactory.decodeFile(safeMediaUrl);//The functional module for image decoding     This line is the buggy code
content.insertMedia(new BitmapDrawable(getResources(), bitmap), attrs);//The functional module for image displaying

Error description: line 25, inappropriate code implementation