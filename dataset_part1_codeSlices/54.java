Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate(Bundle savedInstanceState) {
Reset();
public void reset() {
Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
int screenWidth = display.getWidth();
int screenHeight = display.getHeight();
resetImage(screenWidth, screenHeight);
public void resetImage(int w, int h) {
if (mBackgroundBitmapFile.exists()) {
mBitmap = FileUtils.getBitmapScaledToDisplay(mBackgroundBitmapFile, w, h).copy(Bitmap.Config.ARGB_8888, true);
public static Bitmap getBitmapScaledToDisplay(File f, int screenHeight, int screenWidth) {
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), o);//buggy code
int heightScale = o.outHeight / screenHeight;
int widthScale = o.outWidth / screenWidth;
int scale = Math.max(widthScale, heightScale);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
options.inSampleSize = scale;
/**
The end of the  functional module: image resizing
**/
Bitmap b = BitmapFactory.decodeFile(f.getAbsolutePath(), options);//The functional module of image decoding                  buggy code
return b;
mCanvas = new Canvas(mBitmap);//The functional module of image displaying
