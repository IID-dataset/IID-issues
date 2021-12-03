Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void updateFromItem(final LocalItem localItem,final HistoryRecordManager historyRecordManager,final DateTimeFormatter dateTimeFormatter) {
final PlaylistMetadataEntry item = (PlaylistMetadataEntry) localItem;
/**
The begin of a functional module: image decoding+displaying
**/
itemBuilder.displayImage(item.thumbnailUrl, itemThumbnailView,ImageDisplayConstants.DISPLAY_PLAYLIST_OPTIONS);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 13, using unsuitable third-party libraries.

