Triggering condition: display large images
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
fun onBindViewHolder(holder: QkViewHolder, position: Int) {
val uri = getItem(position)
val view = holder.itemView
/**
The begin of a functional module: image decoding+displaying
**/
view.thumbnail.setImageBitmap(bitmap)
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 12, inappropriate code implementation







