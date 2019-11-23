Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public void onStart() {
if (viewsCreated && itemsLoaded) {
onFragmentLoaded();
private void onFragmentLoaded() {
setupHeaderView();
private void setupHeaderView() {
Glide.with(getActivity()).load(feed.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(imgvCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

