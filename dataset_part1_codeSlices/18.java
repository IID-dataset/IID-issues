Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onActivityResult(int requestCode, int resultCode, Intent data) {
addLastTakenPicture();
private void addLastTakenPicture() {
File f = new File(mMediaCapturePath);
Uri capturedImageUri = Uri.fromFile(f);
if (addMedia(capturedImageUri, true)) {
private boolean addMedia(Uri mediaUri, boolean isNew) {
List<Uri> uriList = new ArrayList<>();
uriList.add(mediaUri);
addMediaList(uriList, isNew);
private void addMediaList(@NonNull List<Uri> uriList, boolean isNew) {
List<Uri> fetchedUriList = fetchMediaList(uriList);
mAddMediaListThread = new AddMediaListThread(fetchedUriList, isNew);
mAddMediaListThread.start();
public void run() {
for (Uri mediaUri : uriList) {
if (!processMedia(mediaUri)) {
private boolean processMedia(Uri mediaUri) {
Activity activity = EditPostActivity.this;
String path = MediaUtils.getRealPathFromURI(activity, mediaUri);
final boolean isVideo = MediaUtils.isVideo(mediaUri.toString());
postProcessMedia(mediaUri, path, isVideo);
private void postProcessMedia(final Uri mediaUri, final String path, final boolean isVideo) {
runOnUiThread(new Runnable() {
public void run() {
if (mShowNewEditor || mShowAztecEditor) {
addMediaVisualEditor(mediaUri, path);
private void addMediaVisualEditor(Uri uri, String path) {
MediaModel media = queueFileForUpload(uri, getContentResolver().getType(uri));
private MediaModel queueFileForUpload(Uri uri, String mimeType, MediaUploadState startingState) {
String path = MediaUtils.getRealPathFromURI(this, uri);
MediaModel media = buildMediaModel(uri, mimeType, startingState);
private MediaModel buildMediaModel(Uri uri, String mimeType, MediaUploadState startingState) {
MediaModel media = FluxCUtils.mediaModelFromLocalUri(this, uri, mimeType, mMediaStore, mSite.getId());
if (org.wordpress.android.fluxc.utils.MediaUtils.isVideoMimeType(media.getMimeType())) {
String path = MediaUtils.getRealPathFromURI(this, uri);
media.setThumbnailUrl(getVideoThumbnail(path));
private String getVideoThumbnail(String videoPath) {
String thumbnailPath = null;
File outputFile = File.createTempFile("thumb", ".png", getCacheDir());
FileOutputStream outputStream = new FileOutputStream(outputFile);
/**
The begin of a functional module: image resizing
This functional module is the buggy code
**/
Bitmap thumb = ImageUtils.getVideoFrameFromVideo(videoPath,ImageUtils.getMaximumThumbnailWidthForEditor(this));
public static Bitmap getVideoFrameFromVideo(String videoPath, int maxWidth) {
if (new File(videoPath).exists()) {
Bitmap thumb = ThumbnailUtils.createVideoThumbnail(videoPath, MediaStore.Images.Thumbnails.FULL_SCREEN_KIND);//The functional module of image resizing
return ImageUtils.getScaledBitmapAtLongestSide(thumb, maxWidth);
public static Bitmap getScaledBitmapAtLongestSide(Bitmap bitmap, int targetSize) {
int targetWidth, targetHeight;
if (bitmap.getHeight() > bitmap.getWidth()) {
targetHeight = targetSize;
float percentage = (float) targetSize / bitmap.getHeight();
targetWidth = (int)(bitmap.getWidth() * percentage);
/**
The end of a functional module: image resizing
**/
return Bitmap.createScaledBitmap(bitmap, targetWidth, targetHeight, true);//The functional module of image decoding
if (thumb != null) {
thumb.compress(Bitmap.CompressFormat.PNG, 75, outputStream);//The functional module of image disk caching








