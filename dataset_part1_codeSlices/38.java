Triggering condition: displaying a lot of images
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onFutureDone(Future<BitmapRegionDecoder> future) {
/**
The begin of a functional module: image resizing
**/
BitmapRegionDecoder decoder = future.get();
if (decoder == null) return;
int width = decoder.getWidth();
int height = decoder.getHeight();
BitmapFactory.Options options = new BitmapFactory.Options();
options.inSampleSize = BitmapUtils.computeSampleSize((float) SIZE_BACKUP / Math.max(width, height));
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = decoder.decodeRegion(new Rect(0, 0, width, height), options);//The functional module of image decoding
mHandler.sendMessage(mHandler.obtainMessage(MSG_UPDATE_IMAGE, new ImageBundle(decoder, bitmap)));//The functional module of image displaying
//buggy position        lack of image object releasing