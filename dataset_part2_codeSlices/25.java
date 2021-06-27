Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
val item = items[position]
/**
The begin of a functional module: image decoding+displaying
**/
Picasso.with(holder.imageView.context).load(item.attachment.previewUrl).into(holder.imageView);//buggy code
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 11, misconfiguration of third-party libraries