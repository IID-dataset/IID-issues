Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View convertView, ViewGroup parent) {
Holder holder;
GpodnetPodcast podcast = getItem(position);
if (StringUtils.isNotBlank(podcast.getLogoUrl())) {
Glide.with(convertView.getContext()).load(podcast.getLogoUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(holder.image);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code


