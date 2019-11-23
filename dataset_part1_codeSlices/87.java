Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onStart() {
if (viewsCreated && itemsLoaded) {
onFragmentLoaded();
private void onFragmentLoaded() {
setupHeaderView();
private void setupHeaderView() {
Glide.with(getActivity()).load(feed.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).transform(new FastBlurTransformation(getActivity())).dontAnimate().into(imgvBackground);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code


