Triggering condition: no triggering condition description
Consequence: Abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
prepareMediaPost();
private void prepareMediaPost() {
String mediaId = getActivity().getIntent().getStringExtra(NEW_MEDIA_POST_EXTRA);
addExistingMediaToEditor(mediaId);
private void addExistingMediaToEditor(String mediaId) {
String blogId = String.valueOf(WordPress.getCurrentBlog().getLocalTableBlogId());
WPImageSpan imageSpan = MediaUtils.prepareWPImageSpan(getActivity(), blogId, mediaId);
public static WPImageSpan prepareWPImageSpan(Context context, String blogId, final String mediaId) {
Cursor cursor = WordPress.wpDB.getMediaFile(blogId, mediaId);
String url = cursor.getString(cursor.getColumnIndex("fileURL"));
String mimeType = cursor.getString(cursor.getColumnIndex("mimeType"));
boolean isVideo = mimeType != null && mimeType.contains("video");
Uri uri = Uri.parse(url);
WPImageSpan imageSpan = new WPImageSpan(context, isVideo ? R.drawable.media_movieclip : R.drawable.remote_image, uri);
return imageSpan;
loadWPImageSpanThumbnail(imageSpan);
private void loadWPImageSpanThumbnail(WPImageSpan imageSpan) {
final int maxPictureWidthForContentEditor = 400;
final int minPictureWidthForContentEditor = 200;
MediaFile mediaFile = imageSpan.getMediaFile();
final String mediaId = mediaFile.getMediaId();
String imageURL;
if (WordPress.getCurrentBlog() != null && WordPress.getCurrentBlog().isPhotonCapable()) {
String photonUrl = imageSpan.getImageSource().toString();
imageURL = StringUtils.getPhotonUrl(photonUrl, maxPictureWidthForContentEditor);
WordPress.imageLoader.get(imageURL, new ImageLoader.ImageListener() {}, 0, 0);
public void onResponse(ImageLoader.ImageContainer container, boolean arg1) {
Bitmap downloadedBitmap = container.getBitmap();
Bitmap resizedBitmap;
if (downloadedBitmap.getWidth() <= maxPictureWidthForContentEditor) {
} else {
/**
The begin of a functional module: image resizing
**/
int targetWidth = 400;
ImageHelper ih = new ImageHelper();
resizedBitmap = ih.getThumbnailForWPImageSpan(downloadedBitmap, targetWidth);
public Bitmap getThumbnailForWPImageSpan(Bitmap largeBitmap, int resizeWidth) {
float percentage = (float) resizeWidth / largeBitmap.getWidth();
float proportionateHeight = largeBitmap.getHeight() * percentage;
int resizeHeight = (int) Math.rint(proportionateHeight);
/**
The end of the functional module: image resizing
**/
return Bitmap.createScaledBitmap(largeBitmap, resizeWidth, resizeHeight, true);//the functional module of image decoding
Editable s = mContentEditText.getText();
WPImageSpan[] spans = s.getSpans(0, s.length(), WPImageSpan.class);
if (spans.length != 0) {
for (WPImageSpan is : spans) {
MediaFile mediaFile = is.getMediaFile();
if (mediaId.equals(mediaFile.getMediaId()) && !is.isNetworkImageLoaded() && hasActivity()) {
WPImageSpan imageSpan = new WPImageSpan(getActivity(), resizedBitmap, is.getImageSource());
imageSpan.setMediaFile(is.getMediaFile());
imageSpan.setNetworkImageLoaded(true);
s.setSpan(imageSpan, spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//the functional module of image displaying

Error description:line 41-47, inappropriate code implementation

















































































































