Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


private void initThumbnailViews(@NonNull final StreamInfo info) {
binding.detailThumbnailImageView.setImageResource(R.drawable.dummy_thumbnail_dark);
if (!isEmpty(info.getThumbnailUrl())) {
final ImageLoadingListener onFailListener = new SimpleImageLoadingListener() {
@Override
public void onLoadingFailed(final String imageUri, final View view,final FailReason failReason) {
showSnackBarError(new ErrorInfo(failReason.getCause(), UserAction.LOAD_IMAGE,imageUri, info));
}};
/**
The begin of a functional module: image decoding+displaying
**/
IMAGE_LOADER.displayImage(info.getThumbnailUrl(), binding.detailThumbnailImageView,ImageDisplayConstants.DISPLAY_THUMBNAIL_OPTIONS, onFailListener);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 19, using unsuitable third-party libraries.

