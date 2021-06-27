Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onResponse(ImageLoader.ImageContainer container, boolean isImmediate) {
String localMediaId = String.valueOf(mediaFile.getId());
final String safeMediaPreviewUrl = mediaFile.isVideo() ?Utils.escapeQuotes(StringUtils.notNullStr(mediaFile.getThumbnailURL())) :Utils.escapeQuotes(mediaUrl);
AztecAttributes attrs = new AztecAttributes();
attrs.setValue(ATTR_ID_WP, localMediaId);
attrs.setValue(ATTR_SRC, Utils.escapeQuotes(mediaUrl));
attrs.setValue(ATTR_CLASS, ATTR_STATUS_UPLOADING);
addDefaultSizeClassIfMissing(attrs);
int[] bitmapDimensions = ImageUtils.getImageSize(Uri.parse(safeMediaPreviewUrl), getActivity());
int realBitmapWidth = bitmapDimensions[0];
Bitmap bitmapToShow = ImageUtils.getWPImageSpanThumbnailFromFilePath(getActivity(),safeMediaPreviewUrl,maxWidth > realBitmapWidth && realBitmapWidth > 0 ? realBitmapWidth : maxWidth);//The functional module of image resizing+decoding  buggy code
MediaPredicate localMediaIdPredicate = MediaPredicate.getLocalMediaIdPredicate(localMediaId);
if (bitmapToShow != null) {
if (mediaFile.isVideo()) {
content.insertVideo(new BitmapDrawable(getResources(), bitmapToShow), attrs);//The functional module of image displaying

Error description:line 16, inappropriate code implementation

