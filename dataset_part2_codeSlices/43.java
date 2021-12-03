Triggering condition: display a lot of images
Consequence: running slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


override fun bind(viewBinding: ListStreamItemBinding, position: Int) {
/**
The begin of a functional module: image decoding+displaying
**/
ImageLoader.getInstance().displayImage(stream.thumbnailUrl, viewBinding.itemThumbnailView,ImageDisplayConstants.DISPLAY_THUMBNAIL_OPTIONS)//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 12, using unsuitable third-party libraries.

