Triggering condition: no triggering condition description
Consequence: crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

public ImageHelper(Station station, Context context) {
mContext = context;
if (station != null && station.getStationImageFile() != null && station.getStationImageFile().exists()) {
/**
The begin of a functional module: image decoding+displaying
**/
mInputImage = decodeSampledBitmapFromFile(station.getStationImageFile().toString(), 72, 72);// bug code: have not check whether mInputImage is null
private Bitmap decodeSampledBitmapFromFile(String imageFilePath, int reqWidth, int reqHeight) {
final BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeFile(imageFilePath, options);
options.inSampleSize = calculateSampleParameter(options, reqWidth, reqHeight);
private static int calculateSampleParameter(BitmapFactory.Options options, int reqWidth, int reqHeight) {
final int height = options.outHeight;
final int width = options.outWidth;
int inSampleSize = 1;
if (height > reqHeight || width > reqWidth) {
final int halfHeight = height / 2;
final int halfWidth = width / 2;
while ((halfHeight / inSampleSize) > reqHeight&& (halfWidth / inSampleSize) > reqWidth) {
inSampleSize *= 2;
}}
return inSampleSize;
options.inJustDecodeBounds = false;
return BitmapFactory.decodeFile(imageFilePath, options);
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 12, inappropriate code implementation
