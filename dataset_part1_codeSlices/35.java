Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public static void initStatics(Context context, boolean isDark) {
displayImageOptions = new DisplayImageOptions.Builder().imageScaleType(ImageScaleType.NONE).cacheOnDisc().build();//buggy code             lack of image memory caching
public static boolean setViewValue(View view, Cursor cursor, String groupBoardCode,int columnWidth, int columnHeight,View.OnClickListener overlayListener,View.OnClickListener overflowListener,int options,Typeface titleTypeface){
setImage(viewHolder, cursor, groupBoardCode, flags, columnWidth, columnHeight, options, titleTypeface);
protected static boolean setImage(BoardViewHolder viewHolder, Cursor cursor, String groupBoardCode,int flags, int columnWidth, int columnHeight, int options, Typeface titleTypeface) {
ImageView iv = viewHolder.grid_item_thread_thumb;
String url = imageUrl(iv, boardCode, groupBoardCode, cursor, flags, options);
displayImage(iv, url);
protected static boolean displayImage(final ImageView iv, final String url) {
imageLoader.displayImage(url, iv, displayImageOptions, thumbLoadingListener);//The functional module of image resizing+decoding+displaying

Error description:line 7, lack of necessary functional modules