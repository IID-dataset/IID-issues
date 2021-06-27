Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public static void initStatics(Context context, boolean isDark) {
thumbDisplayImageOptions = new DisplayImageOptions.Builder().cacheOnDisc().imageScaleType(ImageScaleType.NONE).build();//buggy code             lack of image memory caching
static private boolean setImage(ThreadViewHolder viewHolder, final Cursor cursor, int flags,View.OnClickListener expandedImageListener, boolean showContextMenu) {
displayNonHeaderImage(viewHolder.list_item_image, viewHolder.list_item_image_expansion_target, cursor);
static private boolean displayNonHeaderImage(final ImageView iv, final ViewGroup wrapper, final Cursor cursor) {
String url = cursor.getString(cursor.getColumnIndex(ChanPost.POST_IMAGE_URL));
if (url != null && url.equals(iv.getTag(R.id.IMG_URL))) {
}else if (url != null && !url.isEmpty()) {
imageLoader.displayImage(url, iv, thumbDisplayImageOptions, thumbLoadingListener);//The functional module of image resizing+decoding+displaying

Error description:line 7, lack of necessary functional modules






