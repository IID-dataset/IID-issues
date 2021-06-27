Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
resetImage(w, h);
public void resetImage(int w, int h) {
if (backgroundBitmapFile.exists()) {
/**
The begin of a functional module: image resizing
**/
if (w > h) {
int temp = w;
w = h;
h = temp;
bitmap = FileUtils.getBitmapAccuratelyScaledToDisplay(backgroundBitmapFile, w, h).copy(Bitmap.Config.ARGB_8888, true);
public static Bitmap getBitmapAccuratelyScaledToDisplay(File f, int screenHeight,
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), o);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), options);//The functional module of image decoding     buggy code
/**
The begin of a functional module: image resizing
**/
double heightScale = ((double) (o.outHeight)) / screenHeight;
double widthScale = ((double) o.outWidth) / screenWidth;
double scale = Math.max(widthScale, heightScale);
double newHeight = Math.ceil(o.outHeight / scale);
double newWidth = Math.ceil(o.outWidth / scale);
/**
The end of the functional module: image resizing
**/
bitmap = Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, false);//The functional module of image decoding
return bitmap;
canvas = new Canvas(bitmap);//The functional module of image displaying

Error description:line 28, inappropriate code implementation

