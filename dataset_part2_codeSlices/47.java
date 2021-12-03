Triggering condition: display a large image
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void onDataReady(@Nullable InputStream data) {
tempIn = File.createTempFile("resize_", null);
tempOut = File.createTempFile("resize_", null);
OutputStream outputStream = new FileOutputStream(tempIn);
IOUtils.copy(data, outputStream);
outputStream.close();
IOUtils.closeQuietly(data);
/**
The begin of a functional module: image decoding
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
FileInputStream in = new FileInputStream(tempIn);
BitmapFactory.decodeStream(in, null, options);
IOUtils.closeQuietly(in);
if (Math.max(options.outHeight, options.outWidth) >= MAX_DIMENSIONS) {//buggy code
double sampleSize = (double) Math.max(options.outHeight, options.outWidth) / MAX_DIMENSIONS;
options.inSampleSize = (int) Math.pow(2d, Math.floor(Math.log(sampleSize) / Math.log(2d)));
options.inJustDecodeBounds = false;
in = new FileInputStream(tempIn);
Bitmap bitmap = BitmapFactory.decodeStream(in, null, options);
/**
The end of the functional module: image decoding
**/
IOUtils.closeQuietly(in);
Bitmap.CompressFormat format = Build.VERSION.SDK_INT < 30? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.WEBP_LOSSY;



Error description:line 23, inappropriate code implementation







