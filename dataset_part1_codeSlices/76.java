Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public void onLoadFailed(Exception e, Drawable errorDrawable) {
Uri fallbackUri = fallback.get();
TextView txtvPlaceholder = placeholder.get();
ImageView imgvCover = cover.get();
if(fallbackUri != null && txtvPlaceholder != null && imgvCover != null) {
Glide.with(context).load(fallbackUri).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(new CoverTarget(null, txtvPlaceholder, imgvCover));//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

Error description:line 12, misconfiguration of third-party libraries