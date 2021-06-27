Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View getView(final int position, View convertView, ViewGroup parent) {
final String url = list.get(position);
final ImageView iv = (ImageView) convertView.findViewById(R.id.image);
Picasso.with(getContext()).load(url).into(iv);//The functional module of image decoding+displaying      buggy code

Error description:line 9, using unsuitable third-party libraries   