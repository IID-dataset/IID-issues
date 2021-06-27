Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
private fun loadImageFromNetwork(url: String, photoView: ImageView) {
/**
The begin of a functional module: image decoding+displaying
**/
Picasso.with(context).load(url).noPlaceholder().networkPolicy(NetworkPolicy.NO_STORE).into(photoView, object : Callback {})//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 10, misconfiguration of third-party libraries