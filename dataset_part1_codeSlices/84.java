Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public void onStart() {
loadMediaInfo();
private void loadMediaInfo() {
imgvCover.post(new Runnable() {
public void run() {
Context c = getActivity();
if (c != null) {
Glide.with(c).load(media.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().into(imgvCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code


