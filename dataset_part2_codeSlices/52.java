Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

private suspend fun createRemoteViews(context: Context,provider: Provider,artwork: Artwork,widgetWidth: Int,widgetHeight: Int): RemoteViews? {
/**
The begin of a functional module: image decoding
**/
val image = ImageLoader.decode(context.contentResolver, imageUri,widgetWidth / 2, widgetHeight / 2) ?: return null//buggy code
val scaledImage = image.scale(widgetWidth, widgetHeight)
private fun Bitmap.scale(widgetWidth: Int, widgetHeight: Int): Bitmap? {
val largestDimension = max(widgetWidth, widgetHeight)
var width = width
var height = height
when {width > height -> {
val ratio = width.toFloat() / largestDimension
width = largestDimension
height = (height / ratio).toInt()
}
height > width -> {
val ratio = height.toFloat() / largestDimension
height = largestDimension
width = (width / ratio).toInt()
return Bitmap.createScaledBitmap(this, width, height, true)
/**
The end of a functional module: image decoding
**/
/**
The begin of the functional module: image displaying
**/
@LayoutRes val widgetLayout = if (widgetHeight < smallWidgetHeight)R.layout.widget_small else R.layout.widget
val remoteViews = RemoteViews(context.packageName, widgetLayout)
remoteViews.setImageViewBitmap(R.id.widget_background, scaledImage)
/**
The end of the functional module: image displaying
**/


Error description:line 11-25, inappropriate code implementation







