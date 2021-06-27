Triggering condition: no triggering condition description
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onResponse(ImageLoader.ImageContainer container, boolean isImmediate) {
Bitmap downloadedBitmap = container.getBitmap();
int minimumDimension = DisplayUtils.dpToPx(getActivity(), MIN_BITMAP_DIMENSION_DP);
Bitmap resizedBitmap = ImageUtils.getScaledBitmapAtLongestSide(downloadedBitmap, maxWidth);//The functional module of image resizing+decoding  buggy code
public static Bitmap getScaledBitmapAtLongestSide(Bitmap bitmap, int targetSize) {
int targetWidth, targetHeight;
if (bitmap.getHeight() > bitmap.getWidth()) {
targetHeight = targetSize;
float percentage = (float) targetSize / bitmap.getHeight();
targetWidth = (int)(bitmap.getWidth() * percentage);
return Bitmap.createScaledBitmap(bitmap, targetWidth, targetHeight, true);
replaceDrawable(new BitmapDrawable(getResources(), resizedBitmap));//The functional module of image displaying

Error description:line 9, inappropriate code implementation
