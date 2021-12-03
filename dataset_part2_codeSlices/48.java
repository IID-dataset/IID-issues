Triggering condition: display a large image
Consequence: crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


fun <T> T.makeCaptionDialog(existingDescription: String?,previewUri: Uri,onUpdateDescription: (String) -> LiveData<Boolean>) where T : Activity, T : LifecycleOwner {
/**
The begin of a functional module: image decoding+displaying
**/
Glide.with(this).load(previewUri).into(object : CustomTarget<Drawable>() {override fun onLoadCleared(placeholder: Drawable?) {}//buggy code
/**
The end of the functional module: image decoding+displaying
**/


Error description:line 12, misconfiguration of third-party libraries







