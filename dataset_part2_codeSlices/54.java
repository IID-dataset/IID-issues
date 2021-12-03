Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------

private fun GlideRequest<Drawable>.addThumbnail(context: Context,thumbnailUrl: String?,listener: RequestListener<Drawable>): GlideRequest<Drawable> {
/**
The begin of a functional module: image decoding+displaying
**/
val thumbnailRequest = GlideApp.with(context).load(thumbnailUrl).attachRequestListener(listener)
/**
The end of the functional module: image decoding+displaying
**/
Error description:line 11, misconfiguration of third-party libraries

