Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void handleResult(@NonNull final PlaylistInfo result) {
super.handleResult(result);
final String avatarUrl = result.getUploaderAvatarUrl();
if (result.getServiceId() == ServiceList.YouTube.getServiceId()&& (YoutubeParsingHelper.isYoutubeMixId(result.getId())|| YoutubeParsingHelper.isYoutubeMusicMixId(result.getId()))) {
else{
/**
The begin of a functional module: image decoding+displaying
**/
IMAGE_LOADER.displayImage(avatarUrl, headerBinding.uploaderAvatarView,ImageDisplayConstants.DISPLAY_AVATAR_OPTIONS);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 16, using unsuitable third-party libraries.

