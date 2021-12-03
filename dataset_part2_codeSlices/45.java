Triggering condition: display a large image
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void run() {
	/**
The begin of a functional module: image decoding
**/
if (photoToLoad.maxDimPX < 1) {
photoToLoad.maxDimPX = Integer.MAX_VALUE;
bitmap = getImageFromDisk(photoToLoad.url, photoToLoad.maxDimPX, photoToLoad.cropSquare, photoToLoad.roundRadius);
private Bitmap getImageFromDisk(String url, int maxDimPX, boolean cropSquare, ...) {
File f = fileCache.getCachedFile(url);
return UIUtils.decodeImage(f, maxDimPX, cropSquare, …);
public static Bitmap decodeImage(File f, int maxDim) {
BitmapFactory.Options sizeSniffOpts = new BitmapFactory.Options();
sizeSniffOpts.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), sizeSniffOpts);
int sourceWidth = sizeSniffOpts.outWidth;
int sourceHeight = sizeSniffOpts.outHeight;
int downsample = 1;
while ( ((sourceWidth/(downsample*2)) >= maxDim) || ((sourceHeight/(downsample*2)) >= maxDim) ) downsample*=2;
BitmapFactory.Options decodeOpts = new BitmapFactory.Options();
decodeOpts.inSampleSize = downsample;
decodeOpts.inJustDecodeBounds = false;
return BitmapFactory.decodeFile(f.getAbsolutePath(), decodeOpts);
/**
The end of the functional module: image decoding
**/
/**
The begin of a functional module: image displaying
**/
setViewImage(bitmap, photoToLoad);
/**
The end of the functional module: image displaying
**/


Error description:line 8, inappropriate code implementation













fun onBindViewHolder(holder: QkViewHolder, position: Int) {
val uri = getItem(position)
val view = holder.itemView
/**
The begin of a functional module: image decoding+displaying
**/
view.thumbnail.setImageBitmap(bitmap)
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 12, inappropriate code implementation







