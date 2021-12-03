Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void updateFromItem(final InfoItem infoItem,final HistoryRecordManager historyRecordManager) {
final CommentsInfoItem item = (CommentsInfoItem) infoItem;
/**
The begin of a functional module: image decoding+displaying
**/
itemBuilder.getImageLoader().displayImage(item.getUploaderAvatarUrl(),itemThumbnailView,ImageDisplayConstants.DISPLAY_THUMBNAIL_OPTIONS);
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 13, using unsuitable third-party libraries.

