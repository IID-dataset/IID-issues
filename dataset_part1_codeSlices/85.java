Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
private boolean loadMediaInfo() {
Playable media = controller.getMedia();
if (media != null) {
Glide.with(getActivity()).load(media.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(imgvCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

