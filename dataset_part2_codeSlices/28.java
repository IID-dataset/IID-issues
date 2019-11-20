Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
fun onBindViewHolder(holder: QkViewHolder, position: Int) {
val uri = getItem(position)
val view = holder.itemView
/**
The begin of a functional module: image decoding+displaying
**/
Glide.with(context).load(uri).into(view.thumbnail)
/**
The end of the functional module: image decoding+displaying
**/









