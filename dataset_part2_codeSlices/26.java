Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
override fun setupMediaView(url: String) {
if (arguments!!.getBoolean(ViewMediaFragment.ARG_START_POSTPONED_TRANSITION)) {
/**
The begin of a functional module: image decoding+displaying
**/
Picasso.with(context).load(url).noFade().networkPolicy(NetworkPolicy.OFFLINE).into(photoView, object : Callback {})//buggy code
/**
The end of the functional module: image decoding+displaying
**/       
	
Error description:line 11, misconfiguration of third-party libraries	