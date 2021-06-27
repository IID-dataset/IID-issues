Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public void onStart() {
onFragmentLoaded();
private void onFragmentLoaded() {
updateAppearance();
private void updateAppearance() {
Glide.with(getActivity()).load(item.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(imgvCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

Error description:line 12, misconfiguration of third-party libraries

