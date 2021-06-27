Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
protected boolean loadMediaInfo() {
final Playable media = controller.getMedia();
Glide.with(this).load(media.getImageUri()).placeholder(R.color.light_gray).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(butShowCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

Error description:line 9, misconfiguration of third-party libraries