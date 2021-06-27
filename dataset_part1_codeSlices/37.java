Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
static private boolean setHeaderImage(ThreadViewHolder viewHolder, final Cursor cursor, int flags,View.OnClickListener expandedImageListener, boolean showContextMenu) {
displayHeaderImage(viewHolder, cursor, flags, false, showContextMenu);
static private boolean displayHeaderImage(ThreadViewHolder viewHolder, Cursor cursor, int flags, boolean visible,boolean showContextMenu) {
Point imageSize = sizeHeaderImage(cursor, showContextMenu);
ImageSize displayImageSize = new ImageSize(imageSize.x, imageSize.y);
DisplayImageOptions options = createExpandedDisplayImageOptions(displayImageSize);
private static DisplayImageOptions createExpandedDisplayImageOptions(ImageSize imageSize) {
return new DisplayImageOptions.Builder().cacheOnDisc().imageSize(imageSize).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).showStubImage(stub).resetViewBeforeLoading().build();//buggy code             lack of image memory caching
viewHolder.list_item_image_expanded_wrapper.setVisibility(View.VISIBLE);
if (visible)
viewHolder.list_item_image_header.setVisibility(View.VISIBLE);
String url = cursor.getString(cursor.getColumnIndex(ChanPost.POST_IMAGE_URL));
imageLoader.displayImage(url, viewHolder.list_item_image_header, options,visible ? thumbLoadingListener : invisibleThumbLoadingListener);//The functional module of image resizing+decoding+displaying

Error description:line 13, lack of necessary functional modules

 






























