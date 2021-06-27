Triggering condition: displaying a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == REQUEST_PICK_BACKGROUND) {
if (resultCode == RESULT_OK) {
File image = Preferences.cacheConversationBackground(this, data.getData());
public static File cacheConversationBackground(Context context, Uri uri) {
InputStream in = null;
OutputStream out = null;
in = context.getContentResolver().openInputStream(uri);
Bitmap bmap = BitmapFactory.decodeStream(in, null, null);//The functional module of image decoding       buggy code
WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
Display display = wm.getDefaultDisplay();
Bitmap tn = ThumbnailUtils.extractThumbnail(bmap, display.getWidth(), display.getHeight());
bmap.recycle();
File outFile = new File(context.getFilesDir(), "background.png");
out = new FileOutputStream(outFile);
tn.compress(Bitmap.CompressFormat.PNG, 90, out);//The functional module of image disk caching
tn.recycle();//The functional module of image releasing

Error description:line 14, inappropriate code implementation
