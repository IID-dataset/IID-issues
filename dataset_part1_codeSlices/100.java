Triggering condition: handling a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The statement sequence below will be executed many times
public View getView(int position, View convertView, ViewGroup parent) {
dataBinder.onDataBind(context, convertView, items, items.get(position), position);
public void onDataBind(final Context context, final View targetView, List<? extends Item> items, Object item, int position) {
final Album album = (Album) item;
final Handler handler = new Handler();
new Thread(new Runnable() {}).start();
/**
The begin of a functional module: image loading
**/
public void run() {
final String[] urls = coverHelper.getCoverUrl(artist, album.getName(), null, null);
if (urls != null && urls.length > 0) {
int maxSize = albumCover.getLayoutParams().width;
if (maxSize == 0) {
maxSize = 96;
final Bitmap cover = Tools.decodeSampledBitmapFromPath(urls[0], maxSize, maxSize, false);
public static Bitmap decodeSampledBitmapFromPath(String path, int reqWidth, int reqHeight, boolean resizePerfectlty) {
final BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(path, options);
options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
options.inJustDecodeBounds = false;
final Bitmap bitmap = BitmapFactory.decodeFile(path, options);//The functional module of image decoding
return bitmap
/**
The end of a functional module: image loading
**/
//error position        lack of image caching
if (cover != null) {
handler.post(new Runnable() {
/**
The begin of a functional module: image rendering
**/
public void run() {
final CoverBitmapDrawable myCover = new CoverBitmapDrawable(context.getResources(), cover);
albumCover.setImageDrawable(myCover);//The functional module of image displaying
/**
The end of a functional module: image rendering
**/

Error description: line 34, lack of a necessary functional module



