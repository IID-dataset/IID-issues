Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


private void initThumbnailViews(@NonNull final StreamInfo info) {
binding.detailThumbnailImageView.setImageResource(R.drawable.dummy_thumbnail_dark);
if (!isEmpty(info.getUploaderAvatarUrl())) {
/**
The begin of a functional module: image decoding+displaying
**/
IMAGE_LOADER.displayImage(info.getUploaderAvatarUrl(),binding.detailUploaderThumbnailView,ImageDisplayConstants.DISPLAY_AVATAR_OPTIONS);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 14, using unsuitable third-party libraries.

