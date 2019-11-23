Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public void bindView(View view, Context context, Cursor cursor) {
bindNewsView(view, context, cursor);
public static void bindNewsView(View view, Context context, Cursor cursor) {
String imgUrl = cursor.getString(5);
if(imgUrl.isEmpty() || imgUrl.equals("null")) {
} else {
Utils.loadAndSetImage(context, imgUrl, holder.img);
public static void loadAndSetImage(final Context context, final String url, final ImageView img) {
protected Bitmap doInBackground(Void... voids) {
return downloadImageToBitmap(context, url);
public static Bitmap downloadImageToBitmap(Context context, final String url) {
File f = downloadImage(context, url);
return BitmapFactory.decodeFile(f.getAbsolutePath());//The functional module of image decoding
protected void onPostExecute(Bitmap bitmap) {
img.setImageBitmap(bitmap);//The functional module of image displaying
//  error position           lack a functional module of image caching










