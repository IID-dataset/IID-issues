Triggering condition: handling a large image
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (requestCode == photoRequest) {
//buggy position        lack of image size checking
FileUtil.setPhotoFile(projupdImage, update.getThumbnailUrl(), captureFilename, null, null);
public static void setPhotoFile(ImageView imgView, String url, String fn, String projectId, String updateId) {
if (fn == null) { 
} else { 
File f=new File(fn); 
if (!f.exists()) {
} else {
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(fn, o);
final int REQUIRED_SIZE = 140;
int width_tmp = o.outWidth, height_tmp = o.outHeight;
int scale = 1;
while (true) {
if (width_tmp / 2 < REQUIRED_SIZE|| height_tmp / 2 < REQUIRED_SIZE) {
width_tmp /= 2;
height_tmp /= 2;
scale *= 2;
BitmapFactory.Options o2 = new BitmapFactory.Options();
o2.inSampleSize = scale;
/**
The end of the functional module: image resizing
**/			
Bitmap bm = BitmapFactory.decodeFile(fn,o2);//The functional module of image decoding
if (bm == null) {			
} else {
imgView.setImageBitmap(bm);//The functional module of image displaying

Error description:line 19-31, inappropriate code implementation








